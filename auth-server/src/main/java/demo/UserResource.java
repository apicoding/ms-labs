package demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Nous on 01/11/2016.
 */
@RestController
public class UserResource {

    @RequestMapping("/me")
    @ResponseBody
    public Map<String, String> user(Principal principal) {
        System.err.println("The principal : " + principal.getName());
        Map<String, String> map = new LinkedHashMap<>();
        map.put("name", principal.getName());
        return map;
    }
}
