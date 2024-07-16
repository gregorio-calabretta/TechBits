package com.TechBits.ProductService.dtos;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDtoRequest {
    private String name;
    private double price;
    private String description;
}
