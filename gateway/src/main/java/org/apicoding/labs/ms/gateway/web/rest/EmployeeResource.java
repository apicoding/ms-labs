package org.apicoding.labs.ms.gateway.web.rest;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apicoding.labs.ms.gateway.web.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Thomas VAUTRIN on 23/02/2017.
 */
@RestController
@RequestMapping("/api")
public class EmployeeResource {

    private static final List<UserDTO> users = new ArrayList<>();

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    @Transactional(readOnly = true)
    public ResponseEntity<UserDTO> findAll() throws URISyntaxException {
        System.err.println("********** Cote serveur findAll ");
        UserDTO userDTO = new UserDTO();
        userDTO.setCurrentDate(new Date());
        userDTO.setFirstname("Test Firstname");
        userDTO.setLastname("TestLastname");
        return ResponseEntity.ok().body(userDTO);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @Transactional(readOnly = true)
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO userDTO) throws URISyntaxException {
        System.err.println("********** Cote serveur create : " + userDTO.getFirstname());
        SecurityContext c = SecurityContextHolder.getContext();
        users.add(userDTO);
        userDTO.setCurrentDate(new Date());
        return ResponseEntity.ok().body(userDTO);
    }

}
