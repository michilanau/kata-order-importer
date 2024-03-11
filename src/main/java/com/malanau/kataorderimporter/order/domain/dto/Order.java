package com.malanau.kataorderimporter.order.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.malanau.kataorderimporter.order.domain.deserializers.CustomOrderDateDeserializer;
import com.malanau.kataorderimporter.order.domain.deserializers.CustomOrderShipDateDeserializer;
import java.util.Objects;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Order order)) return false;
    return Objects.equals(uuid, order.uuid)
        && Objects.equals(id, order.id)
        && Objects.equals(region, order.region)
        && Objects.equals(country, order.country)
        && Objects.equals(itemType, order.itemType)
        && Objects.equals(salesChannel, order.salesChannel)
        && priority == order.priority
        && Objects.equals(date, order.date)
        && Objects.equals(shipDate, order.shipDate)
        && Objects.equals(unitsSold, order.unitsSold)
        && Objects.equals(unitPrice, order.unitPrice)
        && Objects.equals(unitCost, order.unitCost)
        && Objects.equals(totalRevenue, order.totalRevenue)
        && Objects.equals(totalCost, order.totalCost)
        && Objects.equals(totalProfit, order.totalProfit)
        && Objects.equals(links, order.links);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        uuid,
        id,
        region,
        country,
        itemType,
        salesChannel,
        priority,
        date,
        shipDate,
        unitsSold,
        unitPrice,
        unitCost,
        totalRevenue,
        totalCost,
        totalProfit,
        links);
  }
}
