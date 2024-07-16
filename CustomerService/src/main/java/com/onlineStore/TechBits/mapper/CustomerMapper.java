package com.onlineStore.TechBits.mapper;

import com.onlineStore.TechBits.domain.Customer;
import com.onlineStore.TechBits.dtos.CustomerDtoResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class CustomerMapper {

    public static CustomerDtoResponse map(Customer customer){
        return CustomerDtoResponse.builder().
                id(customer.getId()).
                name(customer.getName()).
                email(customer.getEmail()).build();
    }
    public static List<CustomerDtoResponse> mapAll(List<Customer> customerList){
        List<CustomerDtoResponse> list = new ArrayList<>();
        for (Customer customer : customerList) {
            CustomerDtoResponse mapped = map(customer);
            list.add(mapped);
        }
        return list;
    }
}
