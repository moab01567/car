package site.mohememd.CarsBackend.car.filterSelectionsHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.sql.Types;
import java.util.*;

@Repository
public class CarSelectionsRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private String baseSQLQuery = "SELECT carID, reg," +
            "vin,color,totalDoors,totalSeats,\n" +
            "axlesInUse,totalEngines,length,width,registeredFirst,\n" +
            "registeredNorway,nextEUControl,note,t.transmissionType, cs.statusType,ct.carModel," +
            "cf.FuelName,h.handleName FROM CarDataBase.Car as c\n" +
            "LEFT JOIN CarType as ct on ct.carTypeID = c.carTypeID\n" +
            "LEFT JOIN Transmission as t on t.transmissionID = c.transmissionID\n" +
            "LEFT JOIN CarFuel as cf on cf.carFuelID = c.fuelID\n" +
            "LEFT JOIN CarStatus as cs on cs.carStatusID = c.statusID\n" +
            "LEFT JOIN HandleStatus as h on h.handleStatusID = c.handleStatusID\n";

    private String personSQLQuery = "SELECT o.carID,p.tlf,p.pName, p.sted, p.contacted2 \n" +
            "FROM CarDataBase.Owners as o\n" +
            "JOIN Person as p on p.tlf = o.tlf\n" +
            "WHERE carID=?";


    private String buildSQLQuery(CarSelections carSelections){
        if (carSelections.getConcatenateLists().isEmpty()) return baseSQLQuery;

        String SqlQueryWithAddedWhereClause = baseSQLQuery +"WHERE "+
            addAttributeToWhereClause("ct.carTypeID", carSelections.getCarTypeIds()) +
            addAttributeToWhereClause("t.transmissionID", carSelections.getTransmissionIds()) +
            addAttributeToWhereClause("cf.carFuelID", carSelections.getCarFuelIds()) +
            addAttributeToWhereClause("cs.carStatusID", carSelections.getCarStatusIds()) +
            addAttributeToWhereClause("h.handleStatusID", carSelections.getCarHandleStatusIds()) +
            addAttributeToWhereClause("totalSeats", carSelections.getCarSeatsIds()) +
            addAttributeToWhereClause("registeredFirst", carSelections.getCarFrom(), carSelections.getCarTo()) +
            addAttributeToWhereClause("nextEUControl", carSelections.getEUFrom(), carSelections.getEUTo());
        return SqlQueryWithAddedWhereClause.substring(0, SqlQueryWithAddedWhereClause.length()-4); //removes and
    }
    private String addAttributeToWhereClause(String attribute, List<Integer> carTypeIds) {
        if (carTypeIds.isEmpty()) return "";
        String questionMarks = new String(new char[carTypeIds.size()]).replace("\0","?,");
        questionMarks = questionMarks.substring(0, questionMarks.length() - 1);
        return attribute + " IN ("+ questionMarks + ") "+"and ";

    }
    private String addAttributeToWhereClause(String attribute, String fromDate, String toDate) {
        String buildAttributeQuestionMark = "";

        if (!fromDate.isEmpty())buildAttributeQuestionMark += attribute +" >= ? and ";

        if (!toDate.isEmpty())buildAttributeQuestionMark += attribute +" <= ? and ";

        return  buildAttributeQuestionMark;
    }
    private int[] createIntArrayWithTypes(List<Object> attributeValues) {
        int[]  argTypes = new int[attributeValues.size()];
        for (int i = 0; i < argTypes.length; i++) {
            if(attributeValues.get(i) instanceof Integer) argTypes[i] = Types.INTEGER;

            if(attributeValues.get(i) instanceof String) argTypes[i] = Types.VARCHAR;
        }
        return argTypes;
    }



    private String convertListToSqlSyntax(List<?> list){
        if (list.isEmpty())return null;
        String stringList = list.toString();
        return stringList.substring(1,stringList.length()-1).replace(" ","");
    }

    private String checkIfStringEmptyForSqlSyntax(String string){
        if (string.isEmpty())return null;
        return string;
    }

    public List<CarReg> selectCarsRegByOptions(CarSelections carSelections){

        return jdbcTemplate.query("call selectCarsRegByOptions(?,?,?,?,?,?,?,?,?,?)",
                ((rw, rowNum) -> new CarReg(rw.getInt(1), rw.getString(2))),
                    convertListToSqlSyntax(carSelections.getCarTypeIds()),
                    convertListToSqlSyntax(carSelections.getTransmissionIds()),
                    convertListToSqlSyntax(carSelections.getCarFuelIds()),
                    convertListToSqlSyntax(carSelections.getCarStatusIds()),
                    convertListToSqlSyntax(carSelections.getCarHandleStatusIds()),
                    convertListToSqlSyntax(carSelections.getCarSeatsIds()),
                    checkIfStringEmptyForSqlSyntax(carSelections.getCarFrom()),
                    checkIfStringEmptyForSqlSyntax(carSelections.getCarTo()),
                    checkIfStringEmptyForSqlSyntax(carSelections.getEUFrom()),
                    checkIfStringEmptyForSqlSyntax(carSelections.getEUTo())
        );
    }

    public List<CarReg> selectCarsRegByTlf(int tlf) {
        return jdbcTemplate.query("call selectCarsByOwnerTlf(?)",(rw,num)->{return new CarReg(rw.getInt(1),rw.getString(2));},tlf);
    }

    public List<CarReg> selectCarsRegByReg(String reg) {
        return jdbcTemplate.query("call selectCarByRegNumber(?)",
                (rw,num)->{return new CarReg(rw.getInt(1),rw.getString(2));},reg);
    }
}
