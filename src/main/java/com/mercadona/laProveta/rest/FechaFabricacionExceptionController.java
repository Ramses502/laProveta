package com.mercadona.laProveta.rest;

import com.mercadona.laProveta.exceptions.FechaFabricacionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class FechaFabricacionExceptionController {
    @ExceptionHandler(value = FechaFabricacionException.class)
    public ResponseEntity<Object> exception(FechaFabricacionException exception) {
        return new ResponseEntity<>("Error: fecha de frabicación no proporcionado", HttpStatus.BAD_REQUEST);
    }
}
