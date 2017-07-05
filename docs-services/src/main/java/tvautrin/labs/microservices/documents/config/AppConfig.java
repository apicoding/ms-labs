package tvautrin.labs.microservices.documents.config;

import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Nous on 15/10/2016.
 */
@Configuration
@ComponentScan("tvautrin.labs.microservices")
//@EnableCircuitBreaker
public class AppConfig {
}
