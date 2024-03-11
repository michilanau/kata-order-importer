package com.malanau.kataorderimporter.order.domain;

import com.malanau.kataorderimporter.order.domain.dto.OrderItemType;
import com.malanau.kataorderimporter.shared.domain.StringMother;

public class OrderItemTypeMother {
  public static OrderItemType create(final String value) {
    return new OrderItemType(value);
  }

  public static OrderItemType random() {
    return create(StringMother.random());
  }
}
