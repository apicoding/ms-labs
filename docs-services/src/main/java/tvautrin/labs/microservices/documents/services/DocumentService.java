package tvautrin.labs.microservices.documents.services;

import java.util.List;

import tvautrin.labs.microservices.documents.domain.Document;

/**
 * Created by Thomas VAUTRIN on 20/10/2016.
 */
public interface DocumentService {

    List<Document> findAll();
}
