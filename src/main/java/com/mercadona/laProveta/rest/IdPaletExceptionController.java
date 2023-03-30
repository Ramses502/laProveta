package com.mercadona.laProveta.rest;

import com.mercadona.laProveta.exceptions.IdPaletException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class IdPaletExceptionController {
    @ExceptionHandler(value = IdPaletException.class)
    public ResponseEntity<Object> exception(IdPaletException exception) {
        return new ResponseEntity<>("Error: id de paleta no proporcionado", HttpStatus.BAD_REQUEST);
    }

}
