package org.apicoding.labs.ms.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableAutoConfiguration
@EnableDiscoveryClient
@RestController
@EnableFeignClients
public class WebApplication {


    @Autowired
    RestTemplate rest;
    // @Value("${spring.application.name:user-services}")
    private String appName = "user-services";
    @Autowired
    private LoadBalancerClient loadBalancer;

	/*@RequestMapping("/")
    public ServiceInstance lb() {
		return this.loadBalancer.choose(this.appName);
	}*/

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

    @RequestMapping("/")
    public String rt() {
        System.err.println("Dans le frontal web");
        return this.rest.getForObject("http://" + this.appName + "/", String.class);
    }

    @Bean
    @LoadBalanced
    RestTemplate loadBalancedRestTemplate() {
        return new RestTemplate();
    }
}
