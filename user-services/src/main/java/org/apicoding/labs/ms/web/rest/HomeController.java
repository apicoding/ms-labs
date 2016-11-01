package org.apicoding.labs.ms.web.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by Nous on 29/10/2016.
 */
@RestController
public class HomeController {

    @RequestMapping("/user")
    @ResponseBody
    public String user(Principal principal) {
        System.err.println("************** DANS MICROSERVICE : " + principal.getName());
        return principal.getName();
    }

}
