package org.apicoding.labs.ms.web.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.io.IOException;

/**
 * Created by Nous on 30/10/2016.
 */
public class SpringSessionClientHttpRequestInterceptor implements ClientHttpRequestInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(SpringSessionClientHttpRequestInterceptor.class);


    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {

        RequestAttributes rqtAttributes = RequestContextHolder.getRequestAttributes();
        //request.getHeaders().add("x-auth-token", rqtAttributes.getSessionId());
        logger.info("Added x-auth-token Header: getSessionId -> {}", RequestContextHolder.getRequestAttributes().getSessionId());

        return execution.execute(request, body);
    }
}