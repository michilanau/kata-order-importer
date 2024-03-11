package com.malanau.kataorderimporter.order.domain;

import com.malanau.kataorderimporter.order.domain.dto.OrderUnitsSold;
import com.malanau.kataorderimporter.shared.domain.IntMother;

public class OrderUnitsSoldMother {
  public static OrderUnitsSold create(final Integer value) {
    return new OrderUnitsSold(value);
  }

  public static OrderUnitsSold random() {
    return create(IntMother.random());
  }
}
