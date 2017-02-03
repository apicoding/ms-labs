package org.apicoding.labs.ms.web.rest;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Collection;

/**
 * Created by Nous on 29/10/2016.
 */
@RestController
public class HomeController {

    @RequestMapping("/user")
    @ResponseBody
    public String user(Principal principal) {
        System.err.println("************** DANS MICROSERVICE : " + (principal != null ? principal.getName() : " Aucun principal"));

        if (principal instanceof OAuth2Authentication) {
            Collection<GrantedAuthority> authorities = ((OAuth2Authentication) principal).getAuthorities();
            for (GrantedAuthority ga : authorities) {
                System.err.println("Droit : " + ga.getAuthority());
            }
        }
        return principal != null ? principal.getName() : " Aucun principal";
    }

}
