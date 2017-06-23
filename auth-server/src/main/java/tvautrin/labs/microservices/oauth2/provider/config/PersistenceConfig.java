package tvautrin.labs.microservices.oauth2.provider.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Created by Thomas VAUTRIN on 04/05/2017.
 */
@Configuration
public class PersistenceConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource driver = new DriverManagerDataSource();
        driver.setDriverClassName("org.postgresql.Driver");
        driver.setUrl("jdbc:postgresql://localhost:5432/oauth");
        driver.setUsername("oauth");
        driver.setPassword("oauth");
        return driver;
    }
}
