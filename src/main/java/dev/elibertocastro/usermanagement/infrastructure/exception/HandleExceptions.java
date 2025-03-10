package dev.elibertocastro.usermanagement.infrastructure.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandleExceptions {

  @ExceptionHandler(HttpMessageNotReadableException.class)
  public ResponseEntity handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
    return ResponseEntity.badRequest().body(e.getMessage());
  }
}
