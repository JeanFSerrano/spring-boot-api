package com.springcourse.springbootweb.Advices;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.springcourse.springbootweb.exceptions.ClientNotFoundException;

@RestControllerAdvice
public class ClientNotFoundAdvice {

    
    @ResponseBody
    @ExceptionHandler(ClientNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)

   String clientNotFoundHandler (ClientNotFoundException ex) {
        return ex.getMessage();

    }
    
}
