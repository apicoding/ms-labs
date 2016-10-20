package org.apicoding.labs.ms.web.services;

/**
 * Created by Nous on 15/10/2016.
 */
public enum ServiceNamesEnum {

    USER_SERVICE("user-services");

    private String serviceName;

    ServiceNamesEnum(String serviceName) {
        this.serviceName = serviceName;
    }

    @Override
    public String toString() {
        return serviceName;
    }
}
