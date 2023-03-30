package com.mercadona.laProveta.rest;

import com.mercadona.laProveta.exceptions.PesoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PesoExceptionController {
    @ExceptionHandler(value = PesoException.class)
    public ResponseEntity<Object> exception(PesoException exception) {
        return new ResponseEntity<>("Error: peso no proporcionado", HttpStatus.BAD_REQUEST);
    }
}
