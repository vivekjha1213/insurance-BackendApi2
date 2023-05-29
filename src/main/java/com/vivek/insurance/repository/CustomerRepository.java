package com.vivek.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.vivek.insurance.model.Customer;


public interface CustomerRepository extends JpaRepository<Customer, String> {
    void deleteById(String id);
}