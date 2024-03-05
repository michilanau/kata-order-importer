package com.malanau.kataorderimporter.order.infrastructure.persistence;

import com.malanau.kataorderimporter.order.domain.Order;
import com.malanau.kataorderimporter.order.domain.OrderRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@AllArgsConstructor
public class MySqlOrderRepository implements OrderRepository {
  @Autowired private JdbcTemplate jdbcTemplate;

  @Override
  public void save(List<Order> orders) {
    orders.forEach(order -> save(order));
  }

  @Override
  public void save(Order order) {
    String sql =
        "INSERT INTO orders (uuid, id, region, country, item_type, sales_channel, priority, "
            + "date, ship_date, units_sold, unit_price, unit_cost, total_revenue, total_cost, "
            + "total_profit, link) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    jdbcTemplate.update(
        sql,
        order.getUuid().getValue(),
        order.getId().getValue(),
        order.getRegion().getValue(),
        order.getCountry().getValue(),
        order.getItemType().getValue(),
        order.getSalesChannel().getValue(),
        order.getPriority().toString(),
        order.getDate().getValue(),
        order.getShipDate().getValue(),
        order.getUnitsSold().getValue(),
        order.getUnitPrice().getValue(),
        order.getUnitCost().getValue(),
        order.getTotalRevenue().getValue(),
        order.getTotalCost().getValue(),
        order.getTotalProfit().getValue(),
        order.getLinks().getSelf().getValue());
  }

  @Override
  public void deleteAll() {
    String sql = "DELETE FROM orders";
    jdbcTemplate.update(sql);
  }
}
