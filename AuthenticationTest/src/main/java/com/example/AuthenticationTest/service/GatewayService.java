package com.example.AuthenticationTest.service;

import com.example.AuthenticationTest.dtos.ProductDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public interface GatewayService {
    public Mono<ResponseEntity<List<ProductDto>>> getRemoteData();

}
