package com.malanau.kataorderimporter.order.domain;

import com.malanau.kataorderimporter.order.domain.dto.OrderUnitCost;
import com.malanau.kataorderimporter.shared.domain.DoubleMother;

public class OrderUnitCostMother {
  public static OrderUnitCost create(final Double value) {
    return new OrderUnitCost(value);
  }

  public static OrderUnitCost random() {
    return create(DoubleMother.random());
  }
}
