package com.malanau.kataorderimporter.order.domain;

import com.malanau.kataorderimporter.order.domain.dto.OrderId;
import com.malanau.kataorderimporter.shared.domain.IntMother;

public class OrderIdMother {
  public static OrderId create(final Integer value) {
    return new OrderId(value);
  }

  public static OrderId random() {
    return create(IntMother.random());
  }
}
