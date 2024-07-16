package com.onlineStore.TechBits.controller;

import com.onlineStore.TechBits.domain.Customer;
import com.onlineStore.TechBits.dtos.CustomerDtoResponse;
import com.onlineStore.TechBits.mapper.CustomerMapper;
import com.onlineStore.TechBits.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/")
    ResponseEntity<List<CustomerDtoResponse>> getAllCustomer(){
        List<Customer> customerList = customerService.getAllCustomers();
        return new ResponseEntity<>(CustomerMapper.mapAll(customerList), HttpStatus.OK);
    }
}
