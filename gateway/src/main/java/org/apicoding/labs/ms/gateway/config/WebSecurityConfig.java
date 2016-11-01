package org.apicoding.labs.ms.gateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;

/**
 * Created by Nous on 31/10/2016.
 */
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        /*if (securityProperties.isRequireSsl()) {
            http.requiresChannel().anyRequest().requiresSecure();
        }*/
        http.authorizeRequests().anyRequest().authenticated();
    }

    @Bean
    public OAuth2RestTemplate loadBalancedOauth2RestTemplate(
            OAuth2ProtectedResourceDetails resource,
            OAuth2ClientContext oauth2Context) {
        OAuth2RestTemplate oauth2RestTemplate = new OAuth2RestTemplate(resource, oauth2Context);
        return oauth2RestTemplate;
    }

}