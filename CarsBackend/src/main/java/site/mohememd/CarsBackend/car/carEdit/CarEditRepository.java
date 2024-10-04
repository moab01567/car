package site.mohememd.CarsBackend.car.carEdit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import site.mohememd.CarsBackend.Message;
import site.mohememd.CarsBackend.exceptions.SomethingIsWrongWithDatabase;

@Repository
public class CarEditRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;


    public Message updateCar(int carId, int value){
        try{
            int row = jdbcTemplate.update("call UpdatehandleStatusID(?,?)", carId, value);
            return new Message("all good total row affected "+row);
        }catch (DataAccessException e){
            throw new SomethingIsWrongWithDatabase();
        }


    }
    public Message UpdateCarFollowUpDate(int carId, String date) {
        try{
            int row = jdbcTemplate.update("call updateFollowUpDate(?,?)", carId, date);
            return new Message("all good total row affected "+row);
        }catch (DataAccessException e){
            throw new SomethingIsWrongWithDatabase();
        }


    }
}
