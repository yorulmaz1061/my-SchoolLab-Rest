package com.cydeo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    //Responsibility of this class is when exception happens, prepare custom json body.
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionWrapper> handleNotFoundException(NotFoundException ex, HttpServletRequest request) {
        //create a json with ExceptionWrapper and return body with 404 status code
        ExceptionWrapper exceptionWrapper = new ExceptionWrapper();
        exceptionWrapper.setTimestamp(LocalDateTime.now());
        exceptionWrapper.setMessage(ex.getMessage());
        exceptionWrapper.setStatus(HttpStatus.NOT_FOUND.value());
        exceptionWrapper.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionWrapper);

    }
}
