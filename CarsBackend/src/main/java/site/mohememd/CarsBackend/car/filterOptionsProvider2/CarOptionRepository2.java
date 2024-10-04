package site.mohememd.CarsBackend.car.filterOptionsProvider2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import site.mohememd.CarsBackend.car.filterOptionsProvider2.options.*;

import java.util.ArrayList;

@Repository
public class CarOptionRepository2 {
    String SQL_QUERY_OPTION = "SELECT * FROM ?";

    @Autowired
    JdbcTemplate jdbcTemplate;

    public ArrayList<CarType> getOptionCarType(){
        ArrayList<CarType> options = new ArrayList<>();
        String SQL_QUERY_CAR_TYPE_OPTION = "SELECT carTypeID, carModel FROM CarType";
        jdbcTemplate.query(SQL_QUERY_CAR_TYPE_OPTION, (rs)-> {
            options.add(new CarType(rs.getInt("carTypeID"),
                    rs.getString("carModel")));
        });
        return options;
    }
    public ArrayList<CarTransmission> getOptionCarTransmission(){

        ArrayList<CarTransmission> options = new ArrayList<>();
        String SQL_QUERY_CAR_TRANSMISSION_OPTION = "SELECT transmissionID, transmissionType FROM Transmission";
        jdbcTemplate.query(SQL_QUERY_CAR_TRANSMISSION_OPTION, (rs)-> {
            options.add(new CarTransmission(rs.getInt("transmissionID"),
                    rs.getString("transmissionType")));
        });
        return options;
    }

    public ArrayList<CarStatus> getOptionCarStatus(){

        ArrayList<CarStatus> options = new ArrayList<>();
        String SQL_QUERY_CAR_TRANSMISSION_OPTION = "SELECT carStatusID, statusType FROM CarStatus";
        jdbcTemplate.query(SQL_QUERY_CAR_TRANSMISSION_OPTION, (rs)-> {
            options.add(new CarStatus(rs.getInt("carStatusID"),
                    rs.getString("statusType")));
        });
        return options;
    }

    public ArrayList<CarFuel> getOptionCarFuel() {
        ArrayList<CarFuel> options = new ArrayList<>();
        String SQL_QUERY_CAR_TRANSMISSION_OPTION = "SELECT carFuelID, FuelName FROM CarFuel";
        jdbcTemplate.query(SQL_QUERY_CAR_TRANSMISSION_OPTION, (rs)-> {
            options.add(new CarFuel(rs.getInt("carFuelID"),
                    rs.getString("FuelName")));
        });
        return options;

    }

    public ArrayList<CarHandleStatus> getOptionCarHandleStatus() {
        ArrayList<CarHandleStatus> options = new ArrayList<>();
        String SQL_QUERY_CAR_TRANSMISSION_OPTION = "SELECT handleStatusID, handleName FROM HandleStatus";
        jdbcTemplate.query(SQL_QUERY_CAR_TRANSMISSION_OPTION, (rs)-> {
            options.add(new CarHandleStatus(rs.getInt("handleStatusID"),
                    rs.getString("handleName")));
        });
        return options;
    }
}
