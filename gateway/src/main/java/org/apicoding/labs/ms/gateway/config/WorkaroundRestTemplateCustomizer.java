package org.apicoding.labs.ms.gateway.config;

import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoRestTemplateCustomizer;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Created by Thomas VAUTRIN on 26/04/2017.
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class WorkaroundRestTemplateCustomizer implements UserInfoRestTemplateCustomizer {

    @Override
    public void customize(OAuth2RestTemplate template) {
        template.setInterceptors(new ArrayList<>(template.getInterceptors()));
    }

}