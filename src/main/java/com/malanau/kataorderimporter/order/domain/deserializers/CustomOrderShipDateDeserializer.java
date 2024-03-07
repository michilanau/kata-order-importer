package com.malanau.kataorderimporter.order.domain.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.malanau.kataorderimporter.order.domain.dto.OrderShipDate;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomOrderShipDateDeserializer extends JsonDeserializer<OrderShipDate> {

  private static final SimpleDateFormat inputFormatter = new SimpleDateFormat("MM/dd/yyyy");
  private static final SimpleDateFormat outputFormatter = new SimpleDateFormat("dd/MM/yyyy");

  @Override
  public OrderShipDate deserialize(
      JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
    try {
      Date date = inputFormatter.parse(jsonParser.getText());
      return new OrderShipDate(outputFormatter.format(date));
    } catch (ParseException e) {
      throw new IOException("Error parsing OrderShipDate", e);
    }
  }
}
