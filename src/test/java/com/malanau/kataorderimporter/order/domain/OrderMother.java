package com.malanau.kataorderimporter.order.domain;

import com.malanau.kataorderimporter.order.domain.dto.Order;
import com.malanau.kataorderimporter.order.domain.dto.OrderCountry;
import com.malanau.kataorderimporter.order.domain.dto.OrderDate;
import com.malanau.kataorderimporter.order.domain.dto.OrderId;
import com.malanau.kataorderimporter.order.domain.dto.OrderItemType;
import com.malanau.kataorderimporter.order.domain.dto.OrderLink;
import com.malanau.kataorderimporter.order.domain.dto.OrderPriority;
import com.malanau.kataorderimporter.order.domain.dto.OrderRegion;
import com.malanau.kataorderimporter.order.domain.dto.OrderSalesChannel;
import com.malanau.kataorderimporter.order.domain.dto.OrderShipDate;
import com.malanau.kataorderimporter.order.domain.dto.OrderTotalCost;
import com.malanau.kataorderimporter.order.domain.dto.OrderTotalProfit;
import com.malanau.kataorderimporter.order.domain.dto.OrderTotalRevenue;
import com.malanau.kataorderimporter.order.domain.dto.OrderUnitCost;
import com.malanau.kataorderimporter.order.domain.dto.OrderUnitPrice;
import com.malanau.kataorderimporter.order.domain.dto.OrderUnitsSold;
import com.malanau.kataorderimporter.order.domain.dto.OrderUuid;

public class OrderMother {
  public static Order create(
      OrderUuid uuid,
      OrderId id,
      OrderRegion region,
      OrderCountry country,
      OrderItemType itemType,
      OrderSalesChannel salesChannel,
      OrderPriority priority,
      OrderDate date,
      OrderShipDate shipDate,
      OrderUnitsSold unitsSold,
      OrderUnitPrice unitPrice,
      OrderUnitCost unitCost,
      OrderTotalRevenue totalRevenue,
      OrderTotalCost totalCost,
      OrderTotalProfit totalProfit,
      OrderLink links) {
    return new Order(
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

  public static Order random() {
    return create(
        OrderUuidMother.random(),
        OrderIdMother.random(),
        OrderRegionMother.random(),
        OrderCountryMother.random(),
        OrderItemTypeMother.random(),
        OrderSalesChannelMother.random(),
        OrderPriorityMother.random(),
        OrderDateMother.random(),
        OrderShipDateMother.random(),
        OrderUnitsSoldMother.random(),
        OrderUnitPriceMother.random(),
        OrderUnitCostMother.random(),
        OrderTotalRevenueMother.random(),
        OrderTotalCostMother.random(),
        OrderTotalProfitMother.random(),
        OrderLinkMother.random());
  }
}
