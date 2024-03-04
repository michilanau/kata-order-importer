package com.malanau.kataorderimporter.health_check.infrastructure.controller;

import java.util.HashMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class HealthCheckController {

  @GetMapping("/health-check")
  public HashMap<String, String> healthCheckGet() {
    final HashMap<String, String> status = new HashMap<>();
    status.put("application", "kata-order-importer");
    status.put("status", "ok");

    return status;
  }
}
