package com.malanau.kataorderimporter.shared.domain;

import java.util.Objects;
import lombok.Getter;

@Getter
public abstract class IntValueObject {
  private final Integer value;

  public IntValueObject(final Integer value) {
    this.value = value;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final IntValueObject that)) {
      return false;
    }
    return Objects.equals(value, that.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }
}
