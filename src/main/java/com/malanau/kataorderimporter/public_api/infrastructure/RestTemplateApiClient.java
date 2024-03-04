package com.malanau.kataorderimporter.public_api.infrastructure;

import com.malanau.kataorderimporter.public_api.domain.ApiClient;
import com.malanau.kataorderimporter.public_api.domain.ApiClientResponse;
import com.malanau.kataorderimporter.public_api.domain.ApiClientResponseBody;
import com.malanau.kataorderimporter.public_api.domain.ApiClientResponseCode;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@AllArgsConstructor
@Service
public class RestTemplateApiClient implements ApiClient {
  RestTemplate restTemplate;

  @Override
  public ApiClientResponse getCall(String url) {
    ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);

    return new ApiClientResponse(
        new ApiClientResponseCode(responseEntity.getStatusCode().value()),
        new ApiClientResponseBody(responseEntity.getBody()));
  }
}
