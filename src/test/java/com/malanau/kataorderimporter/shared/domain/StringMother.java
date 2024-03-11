package com.malanau.kataorderimporter.shared.domain;

public final class StringMother {

  public static String random() {
    return MotherCreator.random().pokemon().name();
  }
}
