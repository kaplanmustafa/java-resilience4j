package com.example.javaresilience4j.controller;

import com.example.javaresilience4j.service.CircuitBreakerService;
import com.example.javaresilience4j.service.RetryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final RetryService retryService;
    private final CircuitBreakerService circuitBreakerService;

    public Controller(RetryService retryService, CircuitBreakerService circuitBreakerService) {
        this.retryService = retryService;
        this.circuitBreakerService = circuitBreakerService;
    }

    @GetMapping
    public String getValues() {
        return retryService.fetchData();
    }

    @GetMapping("/v2")
    public String getValuesV2() {
        return circuitBreakerService.fetchData();
    }
}
