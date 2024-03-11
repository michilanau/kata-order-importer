package com.malanau.kataorderimporter.shared.domain;

public class IntMother {
  public static Integer random() {
    return MotherCreator.random().number().randomDigit();
  }

  public static Integer randomWithRange(Integer min, Integer max) {
    return MotherCreator.random().number().numberBetween(min, max);
  }
}
