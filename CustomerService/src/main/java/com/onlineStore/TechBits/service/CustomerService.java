package com.onlineStore.TechBits.service;

import com.onlineStore.TechBits.domain.Customer;
import com.onlineStore.TechBits.repo.CustomerRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    CustomerRepo customerRepo;

    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public List<Customer> getAllCustomers(){
        return customerRepo.findAll();
    }


}
