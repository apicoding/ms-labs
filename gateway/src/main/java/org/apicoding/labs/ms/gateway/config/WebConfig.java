package org.apicoding.labs.ms.gateway.config;

import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoRestTemplateFactory;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;

/**
 * Created by Nous on 01/11/2016.
 */
@Configuration
public class WebConfig {

    @LoadBalanced
    @Bean
    public OAuth2RestTemplate loadBalancedOauth2RestTemplate(UserInfoRestTemplateFactory userInfoRestTemplateFactory) {
        OAuth2RestTemplate restTemplate = userInfoRestTemplateFactory.getUserInfoRestTemplate();
        return restTemplate;
    }

    @Bean
    public OAuth2FeignRequestInterceptor oAuth2FeignRequestInterceptor(OAuth2ClientContext oAuth2ClientContext, OAuth2ProtectedResourceDetails resourceDetails) {
        return new OAuth2FeignRequestInterceptor(oAuth2ClientContext, resourceDetails);
    }

}
