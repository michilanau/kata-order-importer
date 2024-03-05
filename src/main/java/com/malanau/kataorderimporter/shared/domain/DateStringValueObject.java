package com.malanau.kataorderimporter.shared.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import lombok.Getter;
import org.springframework.util.StringUtils;

@Getter
public abstract class DateStringValueObject extends StringValueObject {

  public DateStringValueObject(String value) {
    this(value, null);
  }

  public DateStringValueObject(String value, String format) {
    super(value);
    ensureIsValidDateString(value, format);
  }

  private void ensureIsValidDateString(String value, String format) {
    if (StringUtils.isEmpty(format)) return;
    SimpleDateFormat dateFormat = new SimpleDateFormat(format);
    dateFormat.setLenient(false);

    try {
      dateFormat.parse(value);
    } catch (ParseException e) {
      throw new IllegalArgumentException(e);
    }
  }
}
