package com.malanau.kataorderimporter.order.application._import;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.malanau.kataorderimporter.order.domain.Order;
import com.malanau.kataorderimporter.order.domain.OrderPage;
import com.malanau.kataorderimporter.order.domain.OrderRepository;
import com.malanau.kataorderimporter.public_api.domain.ApiClient;
import com.malanau.kataorderimporter.public_api.domain.ApiClientResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class OrderImporter {
  private final ApiClient apiClient;
  private final String baseUrl;
  private final OrderRepository orderRepository;

  public OrderImporter(
      ApiClient apiClient, @Value("${api.url}") String baseUrl, OrderRepository orderRepository) {
    this.apiClient = apiClient;
    this.baseUrl = baseUrl;
    this.orderRepository = orderRepository;
  }

  public OrderImporterResponse importOrders() {
    String url = baseUrl;
    OrderPage orderPage;
    List<Order> orders = new ArrayList<>();

    do {
      ApiClientResponse apiClientResponse = apiClient.getCall(url);
      orderPage = parseApiResponse(apiClientResponse);

      if (Objects.isNull(orderPage)) {
        break;
      }

      orderRepository.save(orderPage.getContent());

      orders.addAll(orderPage.getContent());

      if (!StringUtils.isEmpty(orderPage.getLinks().getNext())) {
        url = orderPage.getLinks().getNext().getValue();
      }
    } while (orderPage.hasNextPage());

    return processOrderImporterResponse(orders);
  }

  private OrderImporterResponse processOrderImporterResponse(List<Order> orders) {
    Map<String, Integer> itemTypeCount =
        orders.stream()
            .collect(
                Collectors.groupingBy(
                    order -> order.getItemType().getValue(), Collectors.summingInt(order -> 1)));

    Map<String, Integer> salesChannel =
        orders.stream()
            .collect(
                Collectors.groupingBy(
                    order -> order.getSalesChannel().getValue(),
                    Collectors.summingInt(order -> 1)));

    Map<String, Integer> priority =
        orders.stream()
            .collect(
                Collectors.groupingBy(
                    order -> order.getPriority().toString(), Collectors.summingInt(order -> 1)));

    Map<String, Integer> country =
        orders.stream()
            .collect(
                Collectors.groupingBy(
                    order -> order.getCountry().getValue(), Collectors.summingInt(order -> 1)));

    return new OrderImporterResponse(
        orders.size(),
        new HashMap<>(itemTypeCount),
        new HashMap<>(salesChannel),
        new HashMap<>(priority),
        new HashMap<>(country));
  }

  private OrderPage parseApiResponse(ApiClientResponse response) {
    try {
      return new ObjectMapper().readValue(response.getBody().getValue(), OrderPage.class);
    } catch (JsonProcessingException e) {
      // Manejar la excepción o loggearla según sea necesario
      return null;
    }
  }
}
