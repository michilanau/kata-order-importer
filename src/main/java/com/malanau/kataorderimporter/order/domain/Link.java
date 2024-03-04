package com.malanau.kataorderimporter.order.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Link {
  public String self;
  public String next;
  public String prev;
}
