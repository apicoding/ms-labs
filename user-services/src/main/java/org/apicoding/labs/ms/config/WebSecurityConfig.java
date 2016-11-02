package org.apicoding.labs.ms.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * Created by Nous on 29/10/2016.
 */
@Configuration
@EnableOAuth2Sso
@EnableResourceServer
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //http.authorizeRequests().anyRequest().permitAll();// Autorise toutes requetes
        http.authorizeRequests().anyRequest().authenticated(); // Sécurisation des requetes
    }

    @Bean
    //public ResourceServerConfigurer resourceServer(SecurityProperties securityProperties) {
    public ResourceServerConfigurer resourceServer() {
        return new ResourceServerConfigurerAdapter() {
            @Override
            public void configure(ResourceServerSecurityConfigurer resources) {
                //resources.resourceId("menu");
            }

            @Override
            public void configure(HttpSecurity http) throws Exception {
                /*if (securityProperties.isRequireSsl()) {
                    http.requiresChannel().anyRequest().requiresSecure();
                }*/
                http
                        .authorizeRequests()
                        .antMatchers(HttpMethod.GET, "/**").authenticated()//.access("#oauth2.hasScope('menu.read')")
                        .antMatchers(HttpMethod.POST, "/**").authenticated()//access("#oauth2.hasScope('menu.write')")
                        .antMatchers(HttpMethod.PUT, "/**").authenticated()//access("#oauth2.hasScope('menu.write')")
                        .antMatchers(HttpMethod.DELETE, "/**").authenticated();//access("#oauth2.hasScope('menu.write')");
            }
        };
    }

}