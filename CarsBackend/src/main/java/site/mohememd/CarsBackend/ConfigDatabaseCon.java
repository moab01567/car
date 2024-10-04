package site.mohememd.CarsBackend;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class ConfigDatabaseCon {
    @Bean
    public DriverManagerDataSource driverManagerDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl(System.getenv("DB_URL"));
        dataSource.setUsername(System.getenv("DB_USER"));
        dataSource.setPassword(System.getenv("DB_PASSWORD"));
        return dataSource;
    }
}
