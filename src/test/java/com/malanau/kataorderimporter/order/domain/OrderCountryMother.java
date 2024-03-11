package com.malanau.kataorderimporter.order.domain;

import com.malanau.kataorderimporter.order.domain.dto.OrderCountry;
import com.malanau.kataorderimporter.shared.domain.StringMother;

public class OrderCountryMother {
  public static OrderCountry create(final String value) {
    return new OrderCountry(value);
  }

  public static OrderCountry random() {
    return create(StringMother.random());
  }
}
