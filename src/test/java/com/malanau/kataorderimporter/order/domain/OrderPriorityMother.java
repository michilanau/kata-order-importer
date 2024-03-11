package com.malanau.kataorderimporter.order.domain;

import com.malanau.kataorderimporter.order.domain.dto.OrderPriority;
import java.util.Random;

public class OrderPriorityMother {
  public static OrderPriority create(final String value) {
    return OrderPriority.valueOf(value);
  }

  public static OrderPriority random() {
    return create(
        OrderPriority.values()[new Random().nextInt(OrderPriority.values().length)].name());
  }
}
