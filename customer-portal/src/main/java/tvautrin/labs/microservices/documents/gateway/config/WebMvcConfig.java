package tvautrin.labs.microservices.documents.gateway.config;

import tvautrin.labs.microservices.documents.gateway.LoggingInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Thomas VAUTRIN on 13/02/2017.
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // registry.addInterceptor(loggingInterceptor());
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*").allowCredentials(false).maxAge(3600).allowedHeaders("Accept", "Content-Type", "Origin", "Authorization", "X-Auth-Token")
                .exposedHeaders("X-Auth-Token", "Authorization").allowedMethods("POST", "GET", "DELETE", "PUT", "OPTIONS");
    }

    @Bean
    public LoggingInterceptor loggingInterceptor() {
        return new LoggingInterceptor();
    }
}
