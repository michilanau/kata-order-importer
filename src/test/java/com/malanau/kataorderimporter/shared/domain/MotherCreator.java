package com.malanau.kataorderimporter.shared.domain;

import com.github.javafaker.Faker;

public final class MotherCreator {
  private static final Faker faker = new Faker();

  public static Faker random() {
    return faker;
  }
}
