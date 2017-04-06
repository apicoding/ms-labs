package org.apicoding.labs.ms.web.rest;

import java.security.Principal;
import java.util.List;

import org.apicoding.labs.ms.domain.Document;
import org.apicoding.labs.ms.services.DocumentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Thomas VAUTRIN on 20/10/2016.
 */
@RestController
@RequestMapping("/documents")
public class DocumentResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(DocumentResource.class);

    @Autowired
    private DocumentService userService;

    @RequestMapping(value = "/findall", produces = "application/json")
    @ResponseBody
    // @PreAuthorize("#oauth2.hasScope('openid') and hasRole('USER')")
    public List<Document> findAll(Principal principal) {
        LOGGER.info("Récupération des documents demandée par {}", principal.getName());
        return userService.findAll();
    }

}
