package com.malanau.kataorderimporter.order.application._import;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.malanau.kataorderimporter.order.domain.OrderPage;
import com.malanau.kataorderimporter.order.domain.OrderRepository;
import com.malanau.kataorderimporter.public_api.domain.ApiClient;
import com.malanau.kataorderimporter.public_api.domain.ApiClientResponse;
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

  public void importOrders() {
    String url = baseUrl;
    OrderPage orderPage;

    // We make a new importation from zero
    orderRepository.deleteAll();

    do {
      ApiClientResponse apiClientResponse = apiClient.getCall(url);
      orderPage = parseApiResponse(apiClientResponse);

      if (orderPage == null) {
        break;
      }

      orderRepository.save(orderPage.getContent());

      if (!StringUtils.isEmpty(orderPage.getLinks().getNext())) {
        url = orderPage.getLinks().getNext().getValue();
      }
    } while (orderPage.hasNextPage());
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
