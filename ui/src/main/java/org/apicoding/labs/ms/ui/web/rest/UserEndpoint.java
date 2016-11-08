package org.apicoding.labs.ms.ui.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;


/**
 * Created by Nous on 31/10/2016.
 */
@Controller
public class UserEndpoint {

    @Autowired
    @Qualifier("loadBalancedOauth2RestTemplate")
    private OAuth2RestTemplate oauth2RestTemplate;


    @RequestMapping("/user")
    @ResponseBody
    public String index(Model model, Principal principal) {
        String callUrl = String.format("http://%s/user", ServiceNamesEnum.USER_SERVICE);
        String result = this.oauth2RestTemplate.getForObject(callUrl, String.class);
        return String.format("Utilisateur courant : %s - retour du microservice : %s", principal.getName(), result);
    }

}
