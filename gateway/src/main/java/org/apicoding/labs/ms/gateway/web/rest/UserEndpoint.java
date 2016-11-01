package org.apicoding.labs.ms.gateway.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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


    @RequestMapping("/user")
    public String index(Model model, Principal principal) {
        String callUrl = String.format("//%s/user", ServiceNamesEnum.USER_SERVICE);
        String result = this.oauth2RestTemplate.getForObject(callUrl, String.class);
        model.addAttribute("username", principal.getName());
        System.err.println("principal.getName() : " + principal.getName());
        return "login";
    }

    @RequestMapping("/page1")
    public String page1(Model model, Principal principal) {
        String callUrl = String.format("//%s/user", ServiceNamesEnum.USER_SERVICE);
        String result = this.oauth2RestTemplate.getForObject(callUrl, String.class);
        if (principal instanceof OAuth2Authentication) {
            Collection<GrantedAuthority> authorities = ((OAuth2Authentication) principal).getAuthorities();
            for (GrantedAuthority ga : authorities) {
                System.err.println("Droit : " + ga.getAuthority());
            }
        }
        model.addAttribute("username", principal.getName());
        System.err.println("Page1 : " + principal.getName());
        return "login";
    }

    @RequestMapping("/page2")
    public String page2(Model model, Principal principal) {
        String callUrl = String.format("//%s/user", ServiceNamesEnum.USER_SERVICE);
        String result = this.oauth2RestTemplate.getForObject(callUrl, String.class);
        model.addAttribute("username", principal.getName());
        System.err.println("Page2 : " + principal.getName());
        return "login";
    }

    @RequestMapping("/page3")
    public String page3(Model model, Principal principal) {
        String callUrl = String.format("//%s/user", ServiceNamesEnum.USER_SERVICE);
        String result = this.oauth2RestTemplate.getForObject(callUrl, String.class);
        model.addAttribute("username", principal.getName());
        System.err.println("Page3 : " + principal.getName());
        return "login";
    }
}
