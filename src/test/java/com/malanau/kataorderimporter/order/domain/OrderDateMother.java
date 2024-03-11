package com.malanau.kataorderimporter.order.domain;

import com.malanau.kataorderimporter.order.domain.dto.OrderDate;
import com.malanau.kataorderimporter.shared.domain.IntMother;

public class OrderDateMother {
  public static OrderDate create(final String value) {
    return new OrderDate(value);
  }

  public static OrderDate random() {
    return create(
        IntMother.randomWithRange(1, 28)
            + "/"
            + IntMother.randomWithRange(1, 12)
            + "/"
            + IntMother.randomWithRange(1900, 2024));
  }
}
