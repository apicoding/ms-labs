package org.apicoding.labs.ms.web.services;

import org.apicoding.labs.ms.web.domain.User;

import java.security.Principal;
import java.util.List;

/**
 * Created by Thomas VAUTRIN on 20/10/2016.
 */
public interface UserService {

    List<User> findAll();

    Principal callUserService();
}
