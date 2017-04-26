package demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by Thomas VAUTRIN on 26/04/2017.
 */
@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userDAO.getUserInfo(username);
        List<String> autho = userDAO.findAuthorities(username);
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for(String a : autho){
            GrantedAuthority authority = new SimpleGrantedAuthority(a);
            grantedAuthorities.add(authority);
        }

        UserDetails userDetails = (UserDetails) new User(userInfo.getUsername(), userInfo.getPassword(), grantedAuthorities);
        return userDetails;
    }
}
