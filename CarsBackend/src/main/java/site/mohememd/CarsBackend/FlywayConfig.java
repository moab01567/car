package site.mohememd.CarsBackend;

import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlywayConfig {

    @Bean
    public Flyway flyway() {
        // Henter miljøvariabler og konfigurerer Flyway
        Flyway flyway = Flyway.configure()
                .dataSource(System.getenv("DB_URL"), System.getenv("DB_USER"), System.getenv("DB_PASSWORD"))
                .baselineOnMigrate(true)  // Setter baseline hvis migrasjonshistorikk mangler
                .baselineVersion("1")     // Starter baseline fra versjon 1
                .load();

        // Kjører migreringer når bean er initialisert
        flyway.migrate();

        return flyway;
    }
}
