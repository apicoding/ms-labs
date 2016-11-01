package org.apicoding.labs.ms.web.services.impl;

import org.apicoding.labs.ms.web.domain.User;
import org.apicoding.labs.ms.web.services.ServiceNamesEnum;
import org.apicoding.labs.ms.web.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Thomas VAUTRIN on 20/10/2016.
 */
@Service
public class UserServiceImpl implements UserService {

    /*@Autowired
    RestTemplate rest;*/

    @Autowired
    OAuth2ClientContext oauth2ClientContext;

    @Autowired
    @Qualifier("oauth2RestTemplate")
    OAuth2RestTemplate oauth2RestTemplate;


    public List<User> findAll() {
        String callUrl = String.format("http://%s/findall", ServiceNamesEnum.USER_SERVICE);
        return Arrays.asList(this.oauth2RestTemplate.getForObject(callUrl, User[].class));
    }

    @Override
    public Principal callUserService() {
        //Create and initialize the interceptor

        // rest.getInterceptors().add(new SpringSessionClientHttpRequestInterceptor());
        OAuth2AccessToken accessToken = oauth2ClientContext.getAccessToken();
        String callUrl = String.format("http://localhost:8182/user", ServiceNamesEnum.USER_SERVICE);
        return this.oauth2RestTemplate.getForObject(callUrl, Principal.class);
    }

}
