package com.example.controller.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.controller.dao.CustomerDao;
import com.example.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
    
    @Autowired
    CustomerDao dao;

    public void deleteById(Integer id) {
        dao.deleteById(id);
    }

    public List<Customer> findAll() {
        return dao.findAll();
    }

    public Optional<Customer> findById(final Integer id) {
        return dao.findById(id);
    }

    public Customer getById(Integer arg0) {
        return dao.getById(arg0);
    }

    public Customer save( Customer entity) {
        return dao.save(entity);
    }
}
