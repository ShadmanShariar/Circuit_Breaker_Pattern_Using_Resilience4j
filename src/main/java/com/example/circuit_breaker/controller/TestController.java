package com.example.circuit_breaker.controller;

import com.example.circuit_breaker.service.ExternalApiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {
    private final ExternalApiService externalApiService;

    public TestController(ExternalApiService externalApiService) {
        this.externalApiService = externalApiService;
    }

    @GetMapping("/data")
    public String getData() {
        return externalApiService.callExternalApi();
    }
}

