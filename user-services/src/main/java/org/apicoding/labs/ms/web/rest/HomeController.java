package org.apicoding.labs.ms.web.rest;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
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
    @PreAuthorize("#oauth2.hasScope('openid') and hasRole('USER')")
    public String user(Principal principal) {
        System.err.println("************** DROIT USER -  DANS MICROSERVICE : " + (principal != null ? principal.getName() : " Aucun principal"));

        if (principal instanceof OAuth2Authentication) {
            Collection<GrantedAuthority> authorities = ((OAuth2Authentication) principal).getAuthorities();
            for (GrantedAuthority ga : authorities) {
                System.err.println("Droit : " + ga.getAuthority());
            }
        }
        return principal != null ? principal.getName() : " Aucun principal";
    }

    @RequestMapping("/admin")
    @ResponseBody
    @PreAuthorize("#oauth2.hasScope('openid') and hasRole('ADMIN')")
    public String admin(Principal principal) {
        System.err.println("************** DROIT ADMIN - DANS MICROSERVICE : " + (principal != null ? principal.getName() : " Aucun principal"));
        Authentication a = SecurityContextHolder.getContext().getAuthentication();
        if (principal instanceof OAuth2Authentication) {
            Collection<GrantedAuthority> authorities = ((OAuth2Authentication) principal).getAuthorities();
            for (GrantedAuthority ga : authorities) {
                System.err.println("Droit : " + ga.getAuthority());
            }
        }
        return principal != null ? principal.getName() : " Aucun principal";
    }

}
