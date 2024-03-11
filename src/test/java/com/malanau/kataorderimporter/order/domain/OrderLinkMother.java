package com.malanau.kataorderimporter.order.domain;

import com.malanau.kataorderimporter.order.domain.dto.LinkSelf;
import com.malanau.kataorderimporter.order.domain.dto.OrderLink;

public class OrderLinkMother {
  public static OrderLink create(final LinkSelf linkSelf) {
    return new OrderLink(linkSelf);
  }

  public static OrderLink random() {
    return create(LinkSelfMother.random());
  }
}
