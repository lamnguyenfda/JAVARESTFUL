package com.example.controller.services;

import java.util.List;
import java.util.Optional;

import com.example.entity.Customer;

public interface CustomerService {

	void deleteById(Integer id);

	List<Customer> findAll();

	Optional<Customer> findById(Integer id);

	Customer save(Customer entity);

    Customer getById(Integer arg0);
    
} 
