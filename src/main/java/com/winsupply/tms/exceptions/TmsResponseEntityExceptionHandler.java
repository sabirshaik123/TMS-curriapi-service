package com.winsupply.tms.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;


@ControllerAdvice
public class TmsResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    private ResponseEntity<Object> getResponseFromException(Exception e, HttpStatus status) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("message", e.getMessage());
        body.put("timestamp", LocalDateTime.now());
        return new ResponseEntity<>(body, status);
    }

    @ExceptionHandler(InvalidClientException.class)
    public ResponseEntity<Object> handleFileFormatException(InvalidClientException ex) {
        return getResponseFromException(ex, HttpStatus.BAD_REQUEST);
    }

}
