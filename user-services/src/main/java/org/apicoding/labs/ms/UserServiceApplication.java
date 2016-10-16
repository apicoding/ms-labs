package org.apicoding.labs.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@Configuration
@EnableAutoConfiguration
@EnableDiscoveryClient
@RestController
public class UserServiceApplication {

    private static final Random random = new Random();

    private static int idMs;


    public static void main(String[] args) {
        idMs = random.nextInt();
        SpringApplication.run(UserServiceApplication.class, args);
    }

    @RequestMapping("/")
    public String home() {
        System.err.println("Dans mon micro service " + idMs);
        return "Hello World " + idMs;
    }

}
