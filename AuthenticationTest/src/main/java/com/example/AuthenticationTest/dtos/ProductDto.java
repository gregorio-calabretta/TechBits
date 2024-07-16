package com.example.AuthenticationTest.dtos;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;

@Data
@Builder
public class ProductDto {
    private String name;
    private double price;
    private String description;
}
