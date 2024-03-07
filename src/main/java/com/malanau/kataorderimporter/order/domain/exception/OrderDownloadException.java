package com.malanau.kataorderimporter.order.domain.exception;

public final class OrderDownloadException extends RuntimeException {
  public OrderDownloadException(String text) {
    super(text);
  }
}
