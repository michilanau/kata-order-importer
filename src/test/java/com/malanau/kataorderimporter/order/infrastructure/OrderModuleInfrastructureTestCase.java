package com.malanau.kataorderimporter.order.infrastructure;

import com.malanau.kataorderimporter.ContextInfrastructureTestCase;
import com.malanau.kataorderimporter.order.domain.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class OrderModuleInfrastructureTestCase extends ContextInfrastructureTestCase {
  @Autowired protected OrderRepository orderRepository;
}
