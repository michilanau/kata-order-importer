package com.malanau.kataorderimporter.order.domain.repository;

import com.malanau.kataorderimporter.order.domain.dto.Order;
import java.util.List;

public interface OrderRepository {

  void save(List<Order> orders);

  void save(Order order);

  void deleteAll();

  List<Order> findAllOrderedById();
}
