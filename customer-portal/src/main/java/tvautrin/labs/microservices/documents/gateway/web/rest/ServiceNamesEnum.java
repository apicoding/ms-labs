package tvautrin.labs.microservices.documents.gateway.web.rest;

/**
 * Created by Nous on 15/10/2016.
 */
public enum ServiceNamesEnum {

    USER_SERVICE("user-services"),

    DOCUMENTS_SERVICE("document-services");

    private String serviceName;

    ServiceNamesEnum(String serviceName) {
        this.serviceName = serviceName;
    }

    @Override
    public String toString() {
        return serviceName;
    }
}
