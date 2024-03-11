package com.malanau.kataorderimporter.order.domain;

import com.malanau.kataorderimporter.order.domain.dto.OrderUuid;
import com.malanau.kataorderimporter.shared.domain.UuidMother;

public class OrderUuidMother {
  public static OrderUuid create(String value) {
    return new OrderUuid(value);
  }

  public static OrderUuid random() {
    return create(UuidMother.random());
  }
}
