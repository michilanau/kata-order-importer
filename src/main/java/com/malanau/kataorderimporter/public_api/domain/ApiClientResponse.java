package com.malanau.kataorderimporter.public_api.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ApiClientResponse {
  ApiClientResponseCode code;
  ApiClientResponseBody body;
}
