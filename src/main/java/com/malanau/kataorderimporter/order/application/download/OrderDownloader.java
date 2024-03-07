package com.malanau.kataorderimporter.order.application.download;

import com.malanau.kataorderimporter.order.application.find.OrderFinder;
import com.malanau.kataorderimporter.order.domain.Order;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

@Service
public class OrderDownloader {
  private final OrderFinder orderFinder;
  private final String fileName;

  public OrderDownloader(OrderFinder orderFinder, @Value("${csv.name}") String fileName) {
    this.orderFinder = orderFinder;
    this.fileName = fileName;
  }

  public void downloadCsv(HttpServletResponse response) throws IOException {

    List<Order> orders = orderFinder.findAllOrderedById();

    response.setContentType("text/csv");
    response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "");

    PrintWriter writer = response.getWriter();
    writer.println(
        "Order ID,Order Priority,Order Date,Region,Country,Item Type,Sales Channel,Ship Date,Units Sold,Unit Price,Unit Cost,Total Revenue,Total Cost,Total Profit");

    orders.forEach(
        order ->
            writer.println(
                order.getId().getValue()
                    + ","
                    + order.getPriority().toString()
                    + ","
                    + order.getDate().getValue()
                    + ","
                    + order.getRegion().getValue()
                    + ","
                    + order.getCountry().getValue()
                    + ","
                    + order.getItemType().getValue()
                    + ","
                    + order.getSalesChannel().getValue()
                    + ","
                    + order.getShipDate().getValue()
                    + ","
                    + order.getUnitsSold().getValue()
                    + ","
                    + order.getUnitPrice().getValue()
                    + ","
                    + order.getUnitCost().getValue()
                    + ","
                    + order.getTotalRevenue().getValue()
                    + ","
                    + order.getTotalCost().getValue()
                    + ","
                    + order.getTotalProfit().getValue()));

    writer.flush();
    writer.close();
  }
}
