package com.example.AuthenticationTest.service;

import com.example.AuthenticationTest.dtos.ProductDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class GatewayServiceImpl implements GatewayService{


    private final WebClient.Builder webClientBuilder;

    public GatewayServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public Mono<ResponseEntity<List<ProductDto>>> getRemoteData() {
        String url = "http://localhost:8082/products/";
        return webClientBuilder.build()
                .get()
                .uri(url)
                .retrieve()
                .toEntityList(ProductDto.class);

    }
}
