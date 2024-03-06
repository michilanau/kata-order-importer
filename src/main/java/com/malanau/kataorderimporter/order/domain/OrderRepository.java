package com.malanau.kataorderimporter.order.domain;

import java.util.List;

public interface OrderRepository {

  void save(List<Order> orders);

  void save(Order order);

  void deleteAll();

  List<Order> findAll();
}
