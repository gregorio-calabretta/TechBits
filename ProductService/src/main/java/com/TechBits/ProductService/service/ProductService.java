package com.TechBits.ProductService.service;

import com.TechBits.ProductService.domain.Product;
import com.TechBits.ProductService.repo.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
   private final ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }


    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }


//    public List<Product> insertProducts(@RequestBody ProductDtoRequest productDtoRequest) {
//
//    }
}
