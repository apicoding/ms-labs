package org.apicoding.labs.ms.web.services.impl;

import org.apicoding.labs.ms.web.domain.User;
import org.apicoding.labs.ms.web.services.UserService;
import org.apicoding.labs.ms.web.services.ServiceNamesEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Thomas VAUTRIN on 20/10/2016.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    RestTemplate rest;

    public List<User> findAll(){
        String callUrl = String.format("http://%s/findall", ServiceNamesEnum.USER_SERVICE);
        return Arrays.asList(this.rest.getForObject(callUrl, User[].class));
    }

}
