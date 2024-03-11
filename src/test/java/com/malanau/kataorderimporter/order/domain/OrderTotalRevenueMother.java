package com.malanau.kataorderimporter.order.domain;

import com.malanau.kataorderimporter.order.domain.dto.OrderTotalRevenue;
import com.malanau.kataorderimporter.shared.domain.DoubleMother;

public class OrderTotalRevenueMother {
  public static OrderTotalRevenue create(final Double value) {
    return new OrderTotalRevenue(value);
  }

  public static OrderTotalRevenue random() {
    return create(DoubleMother.random());
  }
}
