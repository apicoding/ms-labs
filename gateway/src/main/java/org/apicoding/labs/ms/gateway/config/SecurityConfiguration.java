package org.apicoding.labs.ms.gateway.config;

import javax.servlet.Filter;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

/**
 * Created by Thomas VAUTRIN on 16/02/2017.
 */
@Configuration
@EnableOAuth2Sso
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // http.antMatcher("/**").authorizeRequests().antMatchers("/").permitAll().anyRequest().permitAll().and().csrf().disable().logout().logoutSuccessUrl("/");
        http.antMatcher("/**").authorizeRequests().antMatchers("/").permitAll().anyRequest().permitAll().and().csrf().disable().logout().logoutSuccessUrl("/").and()
                .addFilterAfter(filter(), BasicAuthenticationFilter.class);
        // http.antMatcher("/**").authorizeRequests().antMatchers("/").authenticated().anyRequest().authenticated().and().csrf().disable().logout().logoutSuccessUrl("/");

    }

    @Bean
    public Filter filter() {
        return new CustomAuthenticationHandler();
    }
}
