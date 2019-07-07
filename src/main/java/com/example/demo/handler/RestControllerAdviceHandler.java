package com.example.demo.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class RestControllerAdviceHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleNotFoundException(Exception ex) {
        log.error("Error occured in Rest Controller ",ex);
        return new ResponseEntity<Object> (ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
