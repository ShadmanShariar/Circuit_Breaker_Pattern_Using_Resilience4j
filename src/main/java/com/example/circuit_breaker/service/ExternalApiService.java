package com.example.circuit_breaker.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExternalApiService {
    private final RestTemplate restTemplate = new RestTemplate();

    @CircuitBreaker(name = "myServiceCircuitBreaker", fallbackMethod = "fallbackResponse")
    public String callExternalApi() {
        // External API call
        return restTemplate.getForObject("https://api.example.com/data", String.class);
    }

    // ফেইল হলে এই মেথড কল হবে
    public String fallbackResponse(Exception ex) {
        return "Fallback response: Default Data";
    }
}

