package com.malanau.kataorderimporter.order.infrastructure.persistence;

import static org.junit.jupiter.api.Assertions.*;

import com.malanau.kataorderimporter.order.domain.OrderMother;
import com.malanau.kataorderimporter.order.domain.dto.Order;
import com.malanau.kataorderimporter.order.infrastructure.OrderModuleInfrastructureTestCase;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

@Transactional
class MySqlOrderRepositoryShould extends OrderModuleInfrastructureTestCase {

  @Test
  void save_a_valid_order() {
    orderRepository.save(orders());
  }

  @Test
  void find_existing_orders_ordered() {

    List<Order> ordersDisordered = orders();

    orderRepository.save(ordersDisordered);

    List<Order> ordersOrdered =
        ordersDisordered.stream()
            .sorted(Comparator.comparing(order -> order.getId().getValue()))
            .toList();

    assertEquals(ordersOrdered, orderRepository.findAllOrderedById());
  }

  private List<Order> orders() {
    return Arrays.asList(OrderMother.random(), OrderMother.random(), OrderMother.random());
  }
}
