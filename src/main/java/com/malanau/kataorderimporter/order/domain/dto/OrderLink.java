package com.malanau.kataorderimporter.order.domain.dto;

import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class OrderLink {
  public LinkSelf self;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof OrderLink orderLink)) return false;
    return Objects.equals(self, orderLink.self);
  }

  @Override
  public int hashCode() {
    return Objects.hash(self);
  }
}
