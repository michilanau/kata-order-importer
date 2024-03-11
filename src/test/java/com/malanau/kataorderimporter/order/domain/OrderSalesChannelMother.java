package com.malanau.kataorderimporter.order.domain;

import com.malanau.kataorderimporter.order.domain.dto.OrderSalesChannel;
import com.malanau.kataorderimporter.shared.domain.StringMother;

public class OrderSalesChannelMother {
  public static OrderSalesChannel create(final String value) {
    return new OrderSalesChannel(value);
  }

  public static OrderSalesChannel random() {
    return create(StringMother.random());
  }
}
