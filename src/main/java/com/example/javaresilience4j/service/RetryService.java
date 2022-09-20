package com.example.javaresilience4j.service;

import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Service
public class RetryService {

    @Value("${service2.url:http://localhost:6060/service2}")
    String serviceUrl;

    @Retry(name = "myRetry", fallbackMethod = "fallback")
    public String fetchData() {
        System.out.println(" Making a request to " + serviceUrl + " at :" + LocalDateTime.now());

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(serviceUrl, String.class);
    }

    public String fallback(Exception e) {
        return "fallback value";
    }
}
