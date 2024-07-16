package com.example.AuthenticationTest.controller;

import com.example.AuthenticationTest.dtos.ProductDto;
import com.example.AuthenticationTest.service.GatewayService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/gateway")
public class GatewayController {

    private final GatewayService gatewayService;

    public GatewayController(GatewayService gatewayService) {
        this.gatewayService = gatewayService;
    }

    @GetMapping
    public  Mono<ResponseEntity<List<ProductDto>>> handleRequest() {
        return gatewayService.getRemoteData();
    }
}
