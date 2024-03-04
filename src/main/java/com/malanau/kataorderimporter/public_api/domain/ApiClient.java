package com.malanau.kataorderimporter.public_api.domain;

public interface ApiClient {
  ApiClientResponse getCall(String url);
}
