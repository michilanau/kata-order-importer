package com.malanau.kataorderimporter.order.infrastructure.exception;

import com.malanau.kataorderimporter.order.domain.exception.OrderDownloadException;
import com.malanau.kataorderimporter.order.domain.exception.OrderImportException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class OrderGlobalExceptionHandler {

  @ExceptionHandler({OrderImportException.class, OrderDownloadException.class})
  public ResponseEntity<String> handleInternalServerException(RuntimeException ex) {
    return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
