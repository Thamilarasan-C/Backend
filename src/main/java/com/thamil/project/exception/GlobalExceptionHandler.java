package com.thamil.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(CustomException.class)
  public ResponseEntity<String> exceptionHandler(CustomException e) {
    return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
  }

  @ExceptionHandler(InternalError.class)
  public ResponseEntity<String> handleException(Exception e) {
    return new ResponseEntity<>("Internal server error", HttpStatus.NOT_FOUND);
  }

}
