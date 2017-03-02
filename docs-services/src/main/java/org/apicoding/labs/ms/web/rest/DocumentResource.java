package org.apicoding.labs.ms.web.rest;

import java.util.List;

import org.apicoding.labs.ms.domain.Document;
import org.apicoding.labs.ms.services.DocumentService;
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

    @Autowired
    private DocumentService userService;

    @RequestMapping("/findall")
    @ResponseBody
    // @PreAuthorize("#oauth2.hasScope('openid') and hasRole('USER')")
    public List<Document> findAll() {
        return userService.findAll();
    }

}
