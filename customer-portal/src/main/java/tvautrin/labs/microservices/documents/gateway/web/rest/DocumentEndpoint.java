package tvautrin.labs.microservices.documents.gateway.web.rest;

import java.security.Principal;
import java.util.List;

import tvautrin.labs.microservices.documents.gateway.services.DocumentService;
import tvautrin.labs.microservices.documents.gateway.web.dto.DocumentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Created by Nous on 31/10/2016.
 */
@Api
@Controller
@RequestMapping("/api/document")
public class DocumentEndpoint {

    @Autowired
    private DocumentService documentService;

    @ApiOperation("findAll")
    @GetMapping(value = "/findall")
    public ResponseEntity<DocumentDTO[]> findAll(Principal principal) {
        List<DocumentDTO> docs = documentService.findAll();
        DocumentDTO[] documents = new DocumentDTO[0];
        if (docs != null && !docs.isEmpty()) {
            documents = docs.toArray(new DocumentDTO[docs.size()]);
        }
        return ResponseEntity.ok().body(documents);
    }

}
