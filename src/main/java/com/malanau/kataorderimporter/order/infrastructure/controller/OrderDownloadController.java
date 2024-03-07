package com.malanau.kataorderimporter.order.infrastructure.controller;

import com.malanau.kataorderimporter.order.application.download.OrderDownloader;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/orders")
public class OrderDownloadController {

  OrderDownloader orderDownloader;

  @GetMapping("/download")
  public void downloadCsv(HttpServletResponse response) {
    orderDownloader.downloadCsv(response);
  }
}
