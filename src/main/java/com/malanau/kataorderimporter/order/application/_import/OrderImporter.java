package com.malanau.kataorderimporter.order.application._import;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.malanau.kataorderimporter.order.domain.Order;
import com.malanau.kataorderimporter.order.domain.PageOrder;
import com.malanau.kataorderimporter.public_api.domain.ApiClient;
import com.malanau.kataorderimporter.public_api.domain.ApiClientResponse;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@AllArgsConstructor
public class OrderImporter {
  private final ApiClient apiClient;
  // private final OrderRepository orderRepository;

  public void importOrders() {
    ApiClientResponse apiClientResponse;
    PageOrder pageOrder = null;
    String url = "https://kata-espublicotech.g3stiona.com/v1/orders";
    List<Order> orders = new ArrayList<>();
    do {

      apiClientResponse = apiClient.getCall(url);

      try {
        pageOrder =
            new ObjectMapper().readValue(apiClientResponse.getBody().getValue(), PageOrder.class);
      } catch (JsonProcessingException e) {

      }

      if (pageOrder == null) {
        break;
      }

      orders.addAll(pageOrder.getContent());

      if (!StringUtils.isEmpty(pageOrder.getLinks().getNext())) {
        url = pageOrder.getLinks().getNext();
      }

    } while (pageOrder.hasNextPage());
  }
}
