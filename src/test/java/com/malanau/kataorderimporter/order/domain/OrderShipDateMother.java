package com.malanau.kataorderimporter.order.domain;

import com.malanau.kataorderimporter.order.domain.dto.OrderShipDate;
import com.malanau.kataorderimporter.shared.domain.IntMother;

public class OrderShipDateMother {
  public static OrderShipDate create(final String value) {
    return new OrderShipDate(value);
  }

  public static OrderShipDate random() {
    return create(
        IntMother.randomWithRange(1, 28)
            + "/"
            + IntMother.randomWithRange(1, 12)
            + "/"
            + IntMother.randomWithRange(1900, 2024));
  }
}
