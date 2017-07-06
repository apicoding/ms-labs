package tvautrin.labs.microservices.documents.client.rest;

/**
 * Created by Thomas VAUTRIN on 25/04/2017.
 */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import tvautrin.labs.microservices.documents.client.rest.dto.DocumentDTO;
import tvautrin.labs.microservices.documents.client.rest.dto.WsConfig;

@SpringBootTest(classes = WsConfig.class)
@RunWith(SpringRunner.class)
public class ClientApplication {

    @Autowired
    private OAuth2RestTemplate restTemplate;

    @Test
    public void home() {
        for (int i = 0; i < 100; i++) {
            DocumentDTO[] result = restTemplate.getForObject("http://localhost:8888/api/documents/findall", DocumentDTO[].class);
            System.err.println(result);
        }
    }

}
