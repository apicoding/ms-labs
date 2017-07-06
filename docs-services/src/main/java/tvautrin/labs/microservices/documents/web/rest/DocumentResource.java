package tvautrin.labs.microservices.documents.web.rest;

import java.security.Principal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import tvautrin.labs.microservices.documents.domain.Document;
import tvautrin.labs.microservices.documents.services.DocumentService;

/**
 * Created by Thomas VAUTRIN on 20/10/2016.
 */
@RestController
@RequestMapping("/api/documents")
@RefreshScope
public class DocumentResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(DocumentResource.class);

    @Autowired
    private DocumentService userService;

    @RequestMapping(value = "/findall", produces = "application/json")
    @ResponseBody
    // @PreAuthorize("#oauth2.hasScope('openid') and hasRole('USER')")
    @HystrixCommand
    public List<Document> findAll(Principal principal) {
        LOGGER.info("Récupération des documents demandée par {}", principal.getName());
        return userService.findAll();
    }

}
