package com.onlineStore.TechBits.repo;

import com.onlineStore.TechBits.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CustomerRepo extends JpaRepository<Customer,Long> {
    List<Customer> findAll();
}
