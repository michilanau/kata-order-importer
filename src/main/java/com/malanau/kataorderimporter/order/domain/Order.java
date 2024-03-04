package com.malanau.kataorderimporter.order.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Order {
  public String uuid;
  public String id;
  public String region;
  public String country;
  public String item_type;
  public String sales_channel;
  public String priority;
  public String date;
  public String ship_date;
  public int units_sold;
  public double unit_price;
  public double unit_cost;
  public double total_revenue;
  public double total_cost;
  public double total_profit;
  public Link links;
}
