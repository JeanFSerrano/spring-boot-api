package com.springcourse.springbootweb.exceptions;

import java.util.UUID;

public class ClientNotFoundException extends RuntimeException {

    public ClientNotFoundException(UUID id) {
        super(String.format("Client with id %s not found!", id));
    }
    
}
