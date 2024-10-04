package site.mohememd.CarsBackend.car.ownerHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import site.mohememd.CarsBackend.Message;
import site.mohememd.CarsBackend.car.Car;
import site.mohememd.CarsBackend.car.Person;
import site.mohememd.CarsBackend.exceptions.SomethingIsWrongWithDatabase;

import java.util.List;

@Repository
public class CarOwnersRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Transactional
    public Message insertOwner(CarOwner carOwner){
        try {
            int rowAffectedPerson = jdbcTemplate.update("call addNewPersonToPersonTable(?,?,?,?)",
                    carOwner.tlf(),
                    carOwner.name(),
                    carOwner.place(),
                    carOwner.contacted());

            int rowAffectedOwners = jdbcTemplate.update("call InsertIntoOwner(?,?)",
                    carOwner.carID(),
                    carOwner.tlf());

            return new Message("Total row Affected: "+ ( rowAffectedPerson+ rowAffectedOwners));
        }catch (IncorrectResultSizeDataAccessException e){
            throw new SomethingIsWrongWithDatabase();
        }catch (DataAccessException e){
            System.out.println(e);
            throw new SomethingIsWrongWithDatabase();
        }
    }
    public Message deleteOwnerFromTable(int carID, int tlf){
        return new Message("Total people deleted is "+ jdbcTemplate.update("call deleteOwnerFromOwnersTable(?,?)" , carID,tlf));

    }


    public List<CarOwner> selectOwnersByCarId(int carId) {
        return jdbcTemplate.query("call selectOwnersByCarId(?)",(rw,num)->{
            return new CarOwner(
                    rw.getInt("carID"),
                    rw.getInt("tlf"),
                    rw.getString("pName"),
                    rw.getString("sted"),
                    rw.getBoolean("contacted"));
        },carId);
    }
}
