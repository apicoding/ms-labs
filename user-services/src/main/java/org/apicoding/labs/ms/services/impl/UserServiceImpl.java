package org.apicoding.labs.ms.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.apicoding.labs.ms.domain.User;
import org.apicoding.labs.ms.services.UserService;
import org.springframework.stereotype.Service;

/**
 * Created by Thomas VAUTRIN on 20/10/2016.
 */
@Service
public class UserServiceImpl implements UserService {

    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "firstname 1", "lastname 1"));
        users.add(new User(2L, "firstname 2", "lastname 2"));
        users.add(new User(3L, "firstname 3", "lastname 3"));
        return users;
    }

}
