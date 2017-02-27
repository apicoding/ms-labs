package org.apicoding.labs.ms.gateway.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by Thomas VAUTRIN on 27/02/2017.
 */
@Component
public class CustomAuthenticationHandler extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.err.println("******************************** CustomAuthenticationFilter");
        // do some logic here if you want something to be done whenever
        // the user successfully logs in.
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        if (SecurityContextHolder.getContext() != null && SecurityContextHolder.getContext().getAuthentication() != null
                && SecurityContextHolder.getContext().getAuthentication().getPrincipal() != null) {
            HttpSession session = httpServletRequest.getSession();
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if(authentication != null && authentication instanceof OAuth2Authentication) {
                OAuth2Authentication oAuth2Authentication =  (OAuth2Authentication)authentication;
                String name = oAuth2Authentication.getName();
                session.setAttribute("username", name);
                session.setAttribute("authorities", oAuth2Authentication.getAuthorities());
                httpServletResponse.setHeader("username", name);
                // httpServletResponse.setHeader("authorities", authentication.getAuthorities());
                // set our response to OK status
                httpServletResponse.setStatus(HttpServletResponse.SC_OK);
                Cookie[] cookies = httpServletRequest.getCookies();
                for (Cookie c : cookies) {
                    System.err.println(c.getName());
                    System.err.println(c.isHttpOnly());

                }
                ObjectMapper mapper = new ObjectMapper();
                String userStr = mapper.writeValueAsString(oAuth2Authentication.getAuthorities());
                Cookie cookieSecured = new Cookie("authorities", userStr);
                cookieSecured.setHttpOnly(true);
                httpServletResponse.addCookie(cookieSecured);
            }
        }
        // since we have created our custom success handler, its up to us to where
        // we will redirect the user after successfully login
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
