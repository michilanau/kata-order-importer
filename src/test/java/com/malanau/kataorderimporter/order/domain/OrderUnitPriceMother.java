package com.malanau.kataorderimporter.order.domain;

import com.malanau.kataorderimporter.order.domain.dto.OrderUnitPrice;
import com.malanau.kataorderimporter.shared.domain.DoubleMother;

public class OrderUnitPriceMother {
  public static OrderUnitPrice create(final Double value) {
    return new OrderUnitPrice(value);
  }

  public static OrderUnitPrice random() {
    return create(DoubleMother.random());
  }
}
