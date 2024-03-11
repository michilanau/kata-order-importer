package com.malanau.kataorderimporter.order.domain;

import com.malanau.kataorderimporter.order.domain.dto.LinkSelf;
import com.malanau.kataorderimporter.shared.domain.StringMother;

public class LinkSelfMother {
  public static LinkSelf create(final String value) {
    return new LinkSelf(value);
  }

  public static LinkSelf random() {
    return create(StringMother.random());
  }
}
