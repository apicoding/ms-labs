package org.apicoding.labs.ms.web.web.rest;

import java.util.List;

import org.apicoding.labs.ms.web.domain.User;
import org.apicoding.labs.ms.web.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Created by Nous on 15/10/2016.
 */
@RestController
@RequestMapping("/user")
@Api(value = "/user")
public class UserResource {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/findall", method = RequestMethod.GET)
    @ApiOperation(value = "Find all users", notes = "Returns a list of user", response = User.class, responseContainer = "List")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success") })
    public @ResponseBody List<User> findAll() {
        List<User> users = userService.findAll();
        return users;
    }

}
