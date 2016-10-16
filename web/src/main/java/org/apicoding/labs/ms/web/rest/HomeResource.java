package org.apicoding.labs.ms.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Nous on 15/10/2016.
 */
@RestController
public class HomeResource {


    @Autowired
    RestTemplate rest;

    private String appName = "user-services";

    @Autowired
    private LoadBalancerClient loadBalancer;

    @RequestMapping("/")
    public String home() {
        System.err.println("Dans le frontal web");
        String callUrl = String.format("http://%s/", ServiceNamesEnum.USER_SERVICE);
        return this.rest.getForObject(callUrl, String.class);
    }
}
