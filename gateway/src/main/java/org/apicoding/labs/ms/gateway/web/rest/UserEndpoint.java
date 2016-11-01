package org.apicoding.labs.ms.gateway.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;


/**
 * Created by Nous on 31/10/2016.
 */
@RestController
public class UserEndpoint {

    @Autowired
    @Qualifier("loadBalancedOauth2RestTemplate")
    private OAuth2RestTemplate oauth2RestTemplate;


    @RequestMapping("/user")
    public String index(Model model, Principal principal) {
        String callUrl = String.format("//%s/user", ServiceNamesEnum.USER_SERVICE);
        String result = this.oauth2RestTemplate.getForObject(callUrl, String.class);
        model.addAttribute("username", principal.getName());
        System.err.println("principal.getName() : " + principal.getName());
        return result;
    }

}
