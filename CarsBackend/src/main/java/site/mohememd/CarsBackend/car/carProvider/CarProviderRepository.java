package site.mohememd.CarsBackend.car.carProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import site.mohememd.CarsBackend.car.Car;
import site.mohememd.CarsBackend.exceptions.SomethingIsWrongWithDatabase;

@Repository
public class CarProviderRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public Car selectCarByID(int carId) {
        try {
        return jdbcTemplate.queryForObject("call selectCarById(?)",(rw,num)->{
            return new Car(
                    rw.getInt("carID"),
                    rw.getString("reg"),
                    rw.getString("vin"),
                    rw.getString("Color"),
                    rw.getInt("totalDoors"),
                    rw.getInt("totalSeats"),
                    rw.getInt("axlesInUse"),
                    rw.getInt("totalEngines"),
                    rw.getFloat("length"),
                    rw.getFloat("width"),
                    rw.getDate("registeredFirst"),
                    rw.getDate("registeredNorway"),
                    rw.getDate("nextEUControl"),
                    rw.getString("note"),
                    rw.getString("transmissionType"),
                    rw.getString("statusType"),
                    rw.getString("carModel"),
                    rw.getString("FuelName"),
                    rw.getInt("handleStatusID"),
                    rw.getString("handleName"),
                    rw.getDate("followUp"));
        },carId);
        }catch (DataAccessException e){
            throw new SomethingIsWrongWithDatabase();
        }
    }


}
