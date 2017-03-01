package demo;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Collection;

/**
 * Created by Nous on 01/11/2016.
 */
@RestController
public class UserResource {

    @RequestMapping("/user")
    @ResponseBody
    public UserInfos user(Principal principal) {
        UserInfos userInfos = new UserInfos();
        System.err.println("The principal : " + principal.getName());
        userInfos.setLogin(principal.getName());
        if (principal instanceof OAuth2Authentication) {
            Collection<GrantedAuthority> authorities = ((OAuth2Authentication) principal).getAuthorities();
            for (GrantedAuthority ga : authorities) {
                userInfos.getAuthorities().add(ga.getAuthority());
                System.err.println("Droit : " + ga.getAuthority());
            }
        }
        return userInfos;
    }
}
