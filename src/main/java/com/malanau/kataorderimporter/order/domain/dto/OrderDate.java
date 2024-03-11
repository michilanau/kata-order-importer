package com.malanau.kataorderimporter.order.domain.dto;

import com.malanau.kataorderimporter.shared.domain.StringValueObject;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class OrderDate extends StringValueObject {
  public OrderDate(String value) {
    super(value);
    ensureIsValidOrderDate(value);
  }

  private void ensureIsValidOrderDate(String value) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    dateFormat.setLenient(false);
    try {
      dateFormat.parse(value);
    } catch (ParseException e) {
      throw new IllegalArgumentException(e);
    }
  }
}
