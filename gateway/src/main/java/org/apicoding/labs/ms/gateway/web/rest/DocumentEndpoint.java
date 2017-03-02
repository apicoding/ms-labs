package org.apicoding.labs.ms.gateway.web.rest;

import org.apicoding.labs.ms.gateway.web.dto.DocumentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Nous on 31/10/2016.
 */
@Controller
@RequestMapping("/api/document")
public class DocumentEndpoint {

    @Autowired
    @Qualifier("loadBalancedOauth2RestTemplate")
    private OAuth2RestTemplate oauth2RestTemplate;

    @GetMapping(value = "/findall")
    public ResponseEntity<DocumentDTO[]> findAll() {
        String callUrl = String.format("http://%s/documents/findall", ServiceNamesEnum.DOCUMENTS_SERVICE);
        DocumentDTO[] documents = this.oauth2RestTemplate.getForObject(callUrl, DocumentDTO[].class);
        return ResponseEntity.ok().body(documents);
    }

}
