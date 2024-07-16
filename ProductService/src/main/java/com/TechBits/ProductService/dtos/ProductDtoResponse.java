package com.TechBits.ProductService.dtos;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;

import java.time.Instant;
@Data
@Builder
public class ProductDtoResponse {
    @JsonProperty
    private ObjectId id;
    @JsonProperty
    private String name;
    @JsonProperty
    private double price;
    @JsonProperty
    private String description;
    @JsonProperty
    private Instant createdDate;
}
