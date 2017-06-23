package tvautrin.labs.microservices.documents.services.impl;

import java.util.ArrayList;
import java.util.List;

import tvautrin.labs.microservices.documents.domain.Document;
import tvautrin.labs.microservices.documents.services.DocumentService;
import org.springframework.stereotype.Service;

/**
 * Created by Thomas VAUTRIN on 20/10/2016.
 */
@Service
public class DocumentServiceImpl implements DocumentService {

    public List<Document> findAll() {
        List<Document> documents = new ArrayList<>();
        documents.add(new Document(1L, "Document 1", "Doc Description 1"));
        documents.add(new Document(2L, "Document 2", "Doc Description 2"));
        documents.add(new Document(3L, "Document 3", "Doc Description 3"));
        return documents;
    }

}
