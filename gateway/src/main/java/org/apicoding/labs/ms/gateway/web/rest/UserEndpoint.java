package org.apicoding.labs.ms.gateway.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;


/**
 * Created by Nous on 31/10/2016.
 */
public class UserEndpoint {

    @Autowired
    @Qualifier("loadBalancedOauth2RestTemplate")
    private OAuth2RestTemplate oauth2RestTemplate;


    @RequestMapping("/")
    public String index(Model model, Principal principal) {
        model.addAttribute("username", principal.getName());
        return "index";
    }


    @RequestMapping(method = RequestMethod.POST, value = "/user")
    public String placeOrder() throws Exception {
        String callUrl = String.format("http://localhost:8182/user", ServiceNamesEnum.USER_SERVICE);
        Principal result = this.oauth2RestTemplate.getForObject(callUrl, Principal.class);
        System.err.println("Resultat du service user dans gateway : " + result);
        return "redirect:.";
    }

}
