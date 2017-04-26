package org.apicoding.labs.ms.client.rest;

/**
 * Created by Thomas VAUTRIN on 25/04/2017.
 */

import org.apicoding.labs.ms.client.rest.dto.DocumentDTO;
import org.apicoding.labs.ms.client.rest.dto.WsConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = WsConfig.class)
@RunWith(SpringRunner.class)
public class ClientApplication {

    @Autowired
    private OAuth2RestTemplate restTemplate;

    @Test
    public void home() {
        DocumentDTO[] result = restTemplate.getForObject("http://localhost:8888/api/document/findall", DocumentDTO[].class);
        System.err.println(result);
    }

}
