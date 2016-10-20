package org.apicoding.labs.ms.web.web.rest;

import java.util.List;

import org.apicoding.labs.ms.web.domain.User;
import org.apicoding.labs.ms.web.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Nous on 15/10/2016.
 */
@RestController
@RequestMapping("/user")
public class UserResource {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public @ResponseBody List<User> findAll() {
        List<User> users = userService.findAll();
        return users;
    }

}
