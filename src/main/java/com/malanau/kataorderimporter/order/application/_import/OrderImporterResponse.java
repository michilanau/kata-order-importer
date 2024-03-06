package com.malanau.kataorderimporter.order.application._import;

import java.util.HashMap;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class OrderImporterResponse {
  private Integer totalImported;
  private HashMap<String, Integer> itemTypes;
  private HashMap<String, Integer> salesChannel;
  private HashMap<String, Integer> priority;
  private HashMap<String, Integer> country;
}
