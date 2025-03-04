package com.icaroreis.webserviceproject.resources.exceptions;

import com.icaroreis.webserviceproject.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;


// anotação que intercpta as expetions que acontecerem
@ControllerAdvice
public class ResourceExceptionHandler  {

    // anotação que intercpta as expetions que acontecerem do tipo NotFounException
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException ex, HttpServletRequest request) {

        // informações que serão lançadas
        String mensage = "Resource Not Found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError standardErr = new StandardError(Instant.now(),status.value(),mensage,ex.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(standardErr);


    }


}
