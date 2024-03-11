package com.malanau.kataorderimporter.order.domain;

import com.malanau.kataorderimporter.order.domain.dto.OrderRegion;
import com.malanau.kataorderimporter.shared.domain.StringMother;

public class OrderRegionMother {
  public static OrderRegion create(final String value) {
    return new OrderRegion(value);
  }

  public static OrderRegion random() {
    return create(StringMother.random());
  }
}
