package com.malanau.kataorderimporter.order.domain;

import com.malanau.kataorderimporter.shared.domain.DateStringValueObject;

public class OrderDate extends DateStringValueObject {
  public OrderDate(String value) {
    super(value, "MM/dd/yyyy");
  }
}
