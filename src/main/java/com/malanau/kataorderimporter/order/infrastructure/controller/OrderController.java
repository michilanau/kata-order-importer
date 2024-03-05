package com.malanau.kataorderimporter.order.infrastructure.controller;

import com.malanau.kataorderimporter.order.application._import.OrderImporter;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/orders")
public class OrderController {

  OrderImporter orderImporter;

  @GetMapping("/import")
  public ResponseEntity<String> importOrders() {

    orderImporter.importOrders();

    return new ResponseEntity<>(HttpStatus.OK);
  }
}
