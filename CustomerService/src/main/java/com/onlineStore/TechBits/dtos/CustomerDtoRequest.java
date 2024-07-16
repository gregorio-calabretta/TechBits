package com.onlineStore.TechBits.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDtoRequest {
    private String name;
    private String email;
}
