package org.apicoding.labs.ms.services;

import java.util.List;

import org.apicoding.labs.ms.domain.User;

/**
 * Created by Thomas VAUTRIN on 20/10/2016.
 */
public interface UserService {

    List<User> findAll();
}
