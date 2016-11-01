package org.apicoding.labs.ms.web.web.rest;

import org.apicoding.labs.ms.web.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by Nous on 29/10/2016.
 */
@RestController
public class HomeController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user")
    public Principal user(Principal principal) {
        Principal principalMS = userService.callUserService();
        return principal;
    }

}
