package org.apicoding.labs.ms.web.rest;

import java.util.List;
import java.util.Random;

import org.apicoding.labs.ms.domain.User;
import org.apicoding.labs.ms.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Thomas VAUTRIN on 20/10/2016.
 */
@RestController
public class UserResource {

    @Autowired
    private UserService userService;

    @RequestMapping("/findall")
    public List<User> findAll() {
        return userService.findAll();
    }

}
