package com.mercadona.laProveta.rest;


import com.mercadona.laProveta.exceptions.IdArticuloException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class IdArticuloExceptionController {
    @ExceptionHandler(value = IdArticuloException.class)
    public ResponseEntity<Object> exception(IdArticuloException exception) {
        return new ResponseEntity<>("Error: id de artículo no proporcionado", HttpStatus.BAD_REQUEST);
    }
}
