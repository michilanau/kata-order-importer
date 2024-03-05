package com.malanau.kataorderimporter.order.domain;

import java.util.List;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class OrderPage {
  public Page page;
  public List<Order> content;
  public Link links;

  public Boolean hasNextPage() {
    return Objects.nonNull(links) && Objects.nonNull(links.getNext());
  }
}
