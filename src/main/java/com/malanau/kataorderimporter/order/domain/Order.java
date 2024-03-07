package com.malanau.kataorderimporter.order.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.malanau.kataorderimporter.order.domain.deserializers.CustomOrderDateDeserializer;
import com.malanau.kataorderimporter.order.domain.deserializers.CustomOrderShipDateDeserializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order {
  public OrderUuid uuid;

  public OrderId id;

  public OrderRegion region;

  public OrderCountry country;

  @JsonProperty("item_type")
  public OrderItemType itemType;

  @JsonProperty("sales_channel")
  public OrderSalesChannel salesChannel;

  public OrderPriority priority;

  @JsonDeserialize(using = CustomOrderDateDeserializer.class)
  public OrderDate date;

  @JsonDeserialize(using = CustomOrderShipDateDeserializer.class)
  @JsonProperty("ship_date")
  public OrderShipDate shipDate;

  @JsonProperty("units_sold")
  public OrderUnitsSold unitsSold;

  @JsonProperty("unit_price")
  public OrderUnitPrice unitPrice;

  @JsonProperty("unit_cost")
  public OrderUnitCost unitCost;

  @JsonProperty("total_revenue")
  public OrderTotalRevenue totalRevenue;

  @JsonProperty("total_cost")
  public OrderTotalCost totalCost;

  @JsonProperty("total_profit")
  public OrderTotalProfit totalProfit;

  public OrderLink links;
}
