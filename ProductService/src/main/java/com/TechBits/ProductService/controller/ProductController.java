package com.TechBits.ProductService.controller;

import com.TechBits.ProductService.domain.Product;
import com.TechBits.ProductService.dtos.ProductDtoResponse;
import com.TechBits.ProductService.mapper.Mapper;
import com.TechBits.ProductService.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController (ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    ResponseEntity<List<ProductDtoResponse>> getAllProducts(){
        List<Product> productList = productService.getAllProducts();
        return new ResponseEntity<>(Mapper.mapAll(productList), HttpStatus.OK);
    }




}
