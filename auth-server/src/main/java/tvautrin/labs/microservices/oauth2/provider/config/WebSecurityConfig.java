package tvautrin.labs.microservices.oauth2.provider.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.ManagementServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by Thomas VAUTRIN on 04/05/2017.
 */
@Configuration
@Order(ManagementServerProperties.ACCESS_OVERRIDE_ORDER)
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**").antMatchers("/**/*.{js,html,css}");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http.formLogin().loginPage("/login").permitAll().and().authorizeRequests().antMatchers("/staks").permitAll()
                .antMatchers("/login", "/oauth/authorize", "/oauth/confirm_access").authenticated().anyRequest().authenticated().and().logout().logoutSuccessUrl("/")
                .deleteCookies("JSESSIONID").and().csrf().disable();
        // @formatter:on
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // @formatter:off
        auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("select username, password, enabled from users where UPPER(username)=UPPER(?)")
                .authoritiesByUsernameQuery("select username, authority from authorities where UPPER(username)=UPPER(?)");
        // @formatter:on

    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}
