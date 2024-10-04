package site.mohememd.CarsBackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import site.mohememd.CarsBackend.auth.AuthRepository;
import site.mohememd.CarsBackend.auth.DatabaseUser;


@SpringBootApplication()
public class CarsBackendApplication {
	public static void main(String[] args) {
		SpringApplication.run(CarsBackendApplication.class, args);
	}

}
