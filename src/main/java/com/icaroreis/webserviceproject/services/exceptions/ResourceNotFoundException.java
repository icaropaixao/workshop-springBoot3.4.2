package com.icaroreis.webserviceproject.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;


    // constructor
    public ResourceNotFoundException(Object id) {

        super("ID: " + id + " Não foi encontrado");

    }

}
