package com.edweb.course.services.exceptions;

//RuntimeException: excessão que o compilador não obriga o tratamento
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Object id) {
        super("Resource not found. Id: " + id);
    }
}
