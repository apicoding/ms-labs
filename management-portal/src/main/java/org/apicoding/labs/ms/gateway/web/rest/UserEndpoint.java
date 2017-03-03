package org.apicoding.labs.ms.gateway.web.rest;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import io.swagger.annotations.Api;
import org.apicoding.labs.ms.gateway.web.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Nous on 31/10/2016.
 */
@Controller
@RequestMapping("/api")
public class UserEndpoint {

    @Autowired
    @Qualifier("loadBalancedOauth2RestTemplate")
    private OAuth2RestTemplate oauth2RestTemplate;

    @GetMapping(value = "/user")
    public ResponseEntity<UserDTO> user(Principal principal) {
        if(principal == null){
            return null;
        }
        OAuth2Authentication oAuth2Authentication = (OAuth2Authentication) principal;
        String name = oAuth2Authentication.getName();
        UserDTO userDTO = new UserDTO();
        userDTO.setLogin(name);
        List<String> authorities = oAuth2Authentication.getAuthorities().stream().map(a -> a.getAuthority()).collect(Collectors.toList());
        userDTO.getAuthorities().addAll(authorities);
        return ResponseEntity.ok().body(userDTO);
    }

    @RequestMapping("/admin-profile")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<UserDTO> adminProfile(Model model, Principal principal) {
        String callUrl = String.format("http://%s/admin", ServiceNamesEnum.USER_SERVICE);
        String result = this.oauth2RestTemplate.getForObject(callUrl, String.class);
        UserDTO userDTO = new UserDTO();
        userDTO.setLogin(String.format("Loggué comme : %s - %s", result, new Date()));
        return ResponseEntity.ok().body(userDTO);
    }

    @RequestMapping("/user-profile")
    public ResponseEntity<UserDTO> userProfile(Model model, Principal principal) {
        String callUrl = String.format("http://%s/user", ServiceNamesEnum.USER_SERVICE);
        String result = this.oauth2RestTemplate.getForObject(callUrl, String.class);
        UserDTO userDTO = new UserDTO();
        userDTO.setLogin(String.format("Loggué comme : %s - %s", result, new Date()));
        return ResponseEntity.ok().body(userDTO);
    }

}
