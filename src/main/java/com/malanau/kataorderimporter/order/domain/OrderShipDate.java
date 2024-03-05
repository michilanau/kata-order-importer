package com.malanau.kataorderimporter.order.domain;

import com.malanau.kataorderimporter.shared.domain.DateStringValueObject;

public class OrderShipDate extends DateStringValueObject {
  public OrderShipDate(String value) {
    super(value, "MM/dd/yyyy");
  }
}
