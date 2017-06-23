package tvautrin.labs.microservices.oauth2.provider.web.rest;

import java.security.Principal;
import java.util.*;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Nous on 01/11/2016.
 */
@RestController
public class UserResource {

    @RequestMapping("/user")
    @ResponseBody
    public Map<String, Object> user(Principal principal) {
        Map<String, Object> map = new LinkedHashMap<>();

        if (principal == null) {
            map.put("isAuthenticated", false);
            return map;
        }
        map.put("isAuthenticated", true);
        map.put("name", principal.getName());
        if (principal instanceof OAuth2Authentication) {
            Collection<GrantedAuthority> authorities = ((OAuth2Authentication) principal).getAuthorities();
            List<String> auth = new ArrayList<>();
            for (GrantedAuthority ga : authorities) {
                auth.add(ga.getAuthority());
            }
            map.put("authorities", StringUtils.join(authorities, ","));
        }
        return map;
    }
}
