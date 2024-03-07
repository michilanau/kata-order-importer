package com.malanau.kataorderimporter.order.domain.exception;

public final class OrderImportException extends RuntimeException {
  public OrderImportException(String text) {
    super(text);
  }
}
