package com.malanau.kataorderimporter.order.domain;

import com.malanau.kataorderimporter.order.domain.dto.OrderTotalProfit;
import com.malanau.kataorderimporter.shared.domain.DoubleMother;

public class OrderTotalProfitMother {
  public static OrderTotalProfit create(final Double value) {
    return new OrderTotalProfit(value);
  }

  public static OrderTotalProfit random() {
    return create(DoubleMother.random());
  }
}
