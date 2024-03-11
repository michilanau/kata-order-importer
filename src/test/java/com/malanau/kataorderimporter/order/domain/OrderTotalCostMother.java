package com.malanau.kataorderimporter.order.domain;

import com.malanau.kataorderimporter.order.domain.dto.OrderTotalCost;
import com.malanau.kataorderimporter.shared.domain.DoubleMother;

public class OrderTotalCostMother {
  public static OrderTotalCost create(final Double value) {
    return new OrderTotalCost(value);
  }

  public static OrderTotalCost random() {
    return create(DoubleMother.random());
  }
}
