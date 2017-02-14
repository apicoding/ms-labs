package org.apicoding.labs.ms.gateway.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.Collection;


/**
 * Created by Nous on 31/10/2016.
 */
@Controller
public class UserEndpoint {

    @Autowired
    @Qualifier("loadBalancedOauth2RestTemplate")
    private OAuth2RestTemplate oauth2RestTemplate;


    @RequestMapping("/admin-profile")
    @ResponseBody
    public String adminProfile(Model model, Principal principal) {
        String callUrl = String.format("http://%s/admin", ServiceNamesEnum.USER_SERVICE);
        String result = this.oauth2RestTemplate.getForObject(callUrl, String.class);
        return String.format("Utilisateur courant : %s - retour du microservice : %s", principal.getName(), result);
    }

    @RequestMapping("/user-profile")
    @ResponseBody
    public String userProfile(Model model, Principal principal) {
        String callUrl = String.format("http://%s/user", ServiceNamesEnum.USER_SERVICE);
        String result = this.oauth2RestTemplate.getForObject(callUrl, String.class);
        return String.format("Utilisateur courant : %s - retour du microservice : %s", principal.getName(), result);
    }

}
