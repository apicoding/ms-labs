package org.apicoding.labs.ms.gateway.web.rest;

import java.security.Principal;

import org.apicoding.labs.ms.gateway.web.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by Nous on 31/10/2016.
 */
@Controller
public class UserEndpoint {

    @Autowired
    @Qualifier("loadBalancedOauth2RestTemplate")
    private OAuth2RestTemplate oauth2RestTemplate;


    @RequestMapping("/admin-profile")
    @Secured("ADMIN")
    public ResponseEntity<UserDTO> adminProfile(Model model, Principal principal) {
        String callUrl = String.format("http://%s/admin", ServiceNamesEnum.USER_SERVICE);
        String result = this.oauth2RestTemplate.getForObject(callUrl, String.class);
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstname(result);
        return ResponseEntity.ok().body(userDTO);
    }

    @RequestMapping("/user-profile")
    public ResponseEntity<UserDTO> userProfile(Model model, Principal principal) {
        String callUrl = String.format("http://%s/user", ServiceNamesEnum.USER_SERVICE);
        String result = this.oauth2RestTemplate.getForObject(callUrl, String.class);
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstname(result);
        return ResponseEntity.ok().body(userDTO);
    }

}
