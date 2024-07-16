package com.TechBits.ProductService.mapper;

import com.TechBits.ProductService.domain.Product;
import com.TechBits.ProductService.dtos.ProductDtoResponse;

import java.util.ArrayList;
import java.util.List;

public class Mapper {
    public static ProductDtoResponse map(Product product){
      return ProductDtoResponse.builder()
              .id(product.getId())
              .name(product.getName())
              .price(product.getPrice())
              .description(product.getDescription())
              .createdDate(product.getCreatedDate()).build();
    }

    public static List<ProductDtoResponse> mapAll(List<Product> productList){
        List<ProductDtoResponse> productDtoResponseList = new ArrayList<>();
        for (Product product : productList){
            productDtoResponseList.add(ProductDtoResponse.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .description(product.getDescription())
                    .price(product.getPrice())
                    .createdDate(product.getCreatedDate()).build());
        }
        return productDtoResponseList;
    }
}
