package tvautrin.labs.microservices.oauth2.provider.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import tvautrin.labs.microservices.oauth2.provider.LoggingInterceptor;

/**
 * Created by Thomas VAUTRIN on 13/02/2017.
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loggingInterceptor());
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/oauth/confirm_access").setViewName("authorize");
    }

    /*
     * @Override public void addCorsMappings(CorsRegistry registry) { registry.addMapping("
     *//**
       * ").allowedOrigins("*").allowCredentials(false).maxAge(3600).allowedHeaders("Accept", "Content-Type", "Origin", "Authorization", "X-Auth-Token")
       * .exposedHeaders("X-Auth-Token", "Authorization").allowedMethods("POST", "GET", "DELETE", "PUT", "OPTIONS"); }
       * 
       * @Override public void addCorsMappings(CorsRegistry registry) { registry.addMapping("
       */
    /**
     * ").allowedOrigins("*"); }
     */

    @Bean
    public LoggingInterceptor loggingInterceptor() {
        return new LoggingInterceptor();
    }
}
