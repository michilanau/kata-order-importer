package com.malanau.kataorderimporter.order.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Link {
  public LinkSelf self;
  public LinkNext next;
  public LinkPrev prev;
}
