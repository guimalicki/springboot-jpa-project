package com.educandoweb.course.services.exceptions;

public class ResourceNotFoundExpection extends RuntimeException {

    public ResourceNotFoundExpection(Object id) {
        super("Resource not found. Id " + id);
    }
}
