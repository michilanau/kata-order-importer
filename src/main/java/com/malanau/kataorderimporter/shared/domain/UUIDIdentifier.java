package com.malanau.kataorderimporter.shared.domain;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;
import lombok.Getter;

@Getter
public abstract class UUIDIdentifier implements Serializable {
  private final String value;

  public UUIDIdentifier(final String value) {
    ensureValidUuid(value);
    this.value = value;
  }

  private void ensureValidUuid(final String value) throws IllegalArgumentException {
    UUID.fromString(value);
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final UUIDIdentifier that)) {
      return false;
    }
    return Objects.equals(value, that.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }
}
