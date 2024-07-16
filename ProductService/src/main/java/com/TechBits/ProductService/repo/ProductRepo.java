package com.TechBits.ProductService.repo;

import com.TechBits.ProductService.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepo extends MongoRepository<Product,String> {
     List<Product> findAll();


}
