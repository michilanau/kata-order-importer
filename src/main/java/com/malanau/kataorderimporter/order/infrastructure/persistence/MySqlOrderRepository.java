package com.malanau.kataorderimporter.order.infrastructure.persistence;

import com.malanau.kataorderimporter.order.domain.LinkSelf;
import com.malanau.kataorderimporter.order.domain.Order;
import com.malanau.kataorderimporter.order.domain.OrderCountry;
import com.malanau.kataorderimporter.order.domain.OrderDate;
import com.malanau.kataorderimporter.order.domain.OrderId;
import com.malanau.kataorderimporter.order.domain.OrderItemType;
import com.malanau.kataorderimporter.order.domain.OrderLink;
import com.malanau.kataorderimporter.order.domain.OrderPriority;
import com.malanau.kataorderimporter.order.domain.OrderRegion;
import com.malanau.kataorderimporter.order.domain.OrderRepository;
import com.malanau.kataorderimporter.order.domain.OrderSalesChannel;
import com.malanau.kataorderimporter.order.domain.OrderShipDate;
import com.malanau.kataorderimporter.order.domain.OrderTotalCost;
import com.malanau.kataorderimporter.order.domain.OrderTotalProfit;
import com.malanau.kataorderimporter.order.domain.OrderTotalRevenue;
import com.malanau.kataorderimporter.order.domain.OrderUnitCost;
import com.malanau.kataorderimporter.order.domain.OrderUnitPrice;
import com.malanau.kataorderimporter.order.domain.OrderUnitsSold;
import com.malanau.kataorderimporter.order.domain.OrderUuid;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            + "total_profit, link) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) "
            + "ON DUPLICATE KEY UPDATE "
            + "uuid = VALUES(uuid), id = VALUES(id), region = VALUES(region), country = VALUES(country), "
            + "item_type = VALUES(item_type), sales_channel = VALUES(sales_channel), priority = VALUES(priority), "
            + "date = VALUES(date), ship_date = VALUES(ship_date), units_sold = VALUES(units_sold), "
            + "unit_price = VALUES(unit_price), unit_cost = VALUES(unit_cost), total_revenue = VALUES(total_revenue), "
            + "total_cost = VALUES(total_cost), total_profit = VALUES(total_profit), link = VALUES(link)";

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

  @Override
  public List<Order> findAll() {
    String sql = "SELECT * FROM orders ORDER BY id";

    return jdbcTemplate.query(sql, (rs, rowNum) -> mapOrder(rs));
  }

  private Order mapOrder(ResultSet rs) throws SQLException {
    Order order =
        new Order(
            new OrderUuid(rs.getString("uuid")),
            new OrderId(rs.getString("id")),
            new OrderRegion(rs.getString("region")),
            new OrderCountry(rs.getString("country")),
            new OrderItemType(rs.getString("item_type")),
            new OrderSalesChannel(rs.getString("sales_channel")),
            OrderPriority.valueOf(rs.getString("priority")),
            new OrderDate(rs.getString("date")),
            new OrderShipDate(rs.getString("ship_date")),
            new OrderUnitsSold(rs.getInt("units_sold")),
            new OrderUnitPrice(rs.getDouble("unit_price")),
            new OrderUnitCost(rs.getDouble("unit_cost")),
            new OrderTotalRevenue(rs.getDouble("total_revenue")),
            new OrderTotalCost(rs.getDouble("total_cost")),
            new OrderTotalProfit(rs.getDouble("total_profit")),
            new OrderLink(new LinkSelf(rs.getString("link"))));
    return order;
  }
}
