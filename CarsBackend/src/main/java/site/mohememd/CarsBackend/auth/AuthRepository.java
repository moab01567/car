package site.mohememd.CarsBackend.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.IncorrectResultSetColumnCountException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import site.mohememd.CarsBackend.exceptions.SomethingIsWrongWithDatabase;
import site.mohememd.CarsBackend.exceptions.WrongUsernameAndPassword;

@Repository
public class AuthRepository {

    private final Logger logger = LoggerFactory.getLogger(AuthRepository.class);
    // SQL query to fetch the user from the database based on the username.
    private final String SQL_QUERY_FIND_USER = "SELECT id, userName, password, role, enabled FROM users WHERE userName = ?";
    private final String SQL_QUERY_ADD_USER = "INSERT INTO users.users(userName, password, role, enabled) VALUES(?,?,?,?)";

    @Autowired
    JdbcTemplate jdbcTemplate;


    public void addUser(String username,String password, String role, boolean enabled){
        jdbcTemplate.update(SQL_QUERY_ADD_USER,username,password,role,enabled);
    }

    // Method to fetch a user from the database by username.
    public DatabaseUser getUserFromDatabase(String username) {
        try {
            return jdbcTemplate.queryForObject(
                    SQL_QUERY_FIND_USER,
                    (rs, rowNum) -> new DatabaseUser(
                            rs.getInt("id"),
                            rs.getString("userName"),
                            rs.getString("password"),
                            rs.getString("role"),
                            rs.getBoolean("enabled")
                    ),
                    username);
        }catch (IncorrectResultSizeDataAccessException | IncorrectResultSetColumnCountException e){
            logger.warn("filed to find user "+ username );
            throw new WrongUsernameAndPassword();
        } catch (DataAccessException e){
            logger.error("Database Error");
            System.out.println(e.getMessage());
            throw new SomethingIsWrongWithDatabase();
        }
    }
}
