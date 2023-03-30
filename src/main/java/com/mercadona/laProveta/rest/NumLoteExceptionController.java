package com.mercadona.laProveta.rest;

import com.mercadona.laProveta.exceptions.NumLoteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class NumLoteExceptionController {
    @ExceptionHandler(value = NumLoteException.class)
    public ResponseEntity<Object> exception(NumLoteException exception) {
        return new ResponseEntity<>("Error: número de lote no proporcionado", HttpStatus.BAD_REQUEST);
    }
}
