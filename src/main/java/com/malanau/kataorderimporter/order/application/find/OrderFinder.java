package com.malanau.kataorderimporter.order.application.find;

import com.malanau.kataorderimporter.order.domain.dto.Order;
import com.malanau.kataorderimporter.order.domain.repository.OrderRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderFinder {
  private final OrderRepository repository;

  public List<Order> findAllOrderedById() {

    return repository.findAllOrderedById();
  }
}
