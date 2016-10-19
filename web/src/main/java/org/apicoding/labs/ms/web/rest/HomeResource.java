package org.apicoding.labs.ms.web.rest;

import org.apicoding.labs.ms.model.DavisCup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nous on 15/10/2016.
 */
@RestController
public class HomeResource {

    @Autowired
    RestTemplate rest;
    private List<DavisCup> resultList = new ArrayList<>();
    private String appName = "user-services";

    @Autowired
    private LoadBalancerClient loadBalancer;

    public HomeResource() {
        resultList.add(new DavisCup(2015, "Great Britain", "Belgium", "3-1"));
        resultList.add(new DavisCup(2014, "Switzerland", "France", "3-1"));
        resultList.add(new DavisCup(2013, "Czech Republic", "Serbia", "3-2"));
    }

    @RequestMapping("/")
    public String home() {
        System.err.println("Dans le frontal web");
        String callUrl = String.format("http://%s/", ServiceNamesEnum.USER_SERVICE);
        return this.rest.getForObject(callUrl, String.class);
    }

    @RequestMapping(value = "/result_list", method = RequestMethod.GET)
    public
    @ResponseBody
    List<DavisCup> resultList() {
        System.err.println("********** DANS resultList");
        return resultList;
    }

    @RequestMapping("/result_year")
    public
    @ResponseBody
    DavisCup result(@RequestParam(required = true, defaultValue = "2015") String year) {
        for (DavisCup current : resultList) {
            if (current.getYear().toString().equals(year)) {
                return current;
            }

        }
        return null;
    }
}
