package site.mohememd.CarsBackend.car.filterOptionsProvider2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class CarFilterRepository {

    public static String selectAllCarTypes = "call selectAllCarType()";
    public static String selectAllCarFuel = "call selectAllCarFuel()";
    public static String selectAllCarStatus = "call selectAllCarStatus()";
    public static String selectAllHandleStatus = "call selectAllHandleStatus()";
    public static String selectAllTransmission = "call selectAllTransmission()";

    @Autowired
    JdbcTemplate jdbcTemplate;
    public <T> List<T>  selectAvailableOptions(String sql, RowMapper<T>rowMapper) {
        return jdbcTemplate.query(sql,rowMapper);
    }
}
