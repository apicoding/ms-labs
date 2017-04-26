package org.apicoding.labs.ms.client.rest.dto;

import java.util.Arrays;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

/**
 * Created by Thomas VAUTRIN on 25/04/2017.
 */
@Configuration
@EnableAutoConfiguration
@EnableOAuth2Client
public class WsConfig {

    @Bean
    public OAuth2RestOperations restTemplate(OAuth2ClientContext oauth2ClientContext, OAuth2ProtectedResourceDetails resources) {
        OAuth2RestTemplate template = new OAuth2RestTemplate(resources(), oauth2ClientContext);
        return template;
    }

    @Bean
    @ConfigurationProperties("security.oauth2.client")
    public ResourceOwnerPasswordResourceDetails resources() {
        ResourceOwnerPasswordResourceDetails resourceOwner = new ResourceOwnerPasswordResourceDetails();
        resourceOwner.setAccessTokenUri("http://localhost:9999/uaa/oauth/token");
        resourceOwner.setClientId("rest-client");
        resourceOwner.setClientSecret("rest-client");
        resourceOwner.setScope(Arrays.asList("read", "write", "openid"));
        resourceOwner.setPassword("password");
        resourceOwner.setUsername("user");
        return resourceOwner;
    }

    /*
     * @Bean public OAuth2RestOperations restTemplate(OAuth2ClientContext oauth2ClientContext, OAuth2ProtectedResourceDetails resources) { MappingJackson2HttpMessageConverter
     * aConverter = new MappingJackson2HttpMessageConverter(); List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>(); converters.add(aConverter);
     * OAuth2RestTemplate template = new OAuth2RestTemplate(resource(), new DefaultOAuth2ClientContext()); template.getMessageConverters().addAll(converters); return template; }
     * 
     * @Bean
     * 
     * @ConfigurationProperties("security.oauth2.client") public ClientCredentialsResourceDetails resource() { return new ClientCredentialsResourceDetails(); }
     */

}
