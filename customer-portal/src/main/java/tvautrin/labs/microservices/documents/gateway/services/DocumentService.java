package tvautrin.labs.microservices.documents.gateway.services;

import java.util.List;

import tvautrin.labs.microservices.documents.gateway.web.dto.DocumentDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Thomas VAUTRIN on 04/04/2017.
 */
@FeignClient(name = "gateway")
public interface DocumentService {

    @RequestMapping("/api/documents/findall")
    List<DocumentDTO> findAll();
}
