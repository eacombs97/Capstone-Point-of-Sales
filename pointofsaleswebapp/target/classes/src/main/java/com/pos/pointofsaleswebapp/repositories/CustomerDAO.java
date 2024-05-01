package com.pos.pointofsaleswebapp.repositories;

import java.util.List;

import com.pos.pointofsaleswebapp.model.Customer;

public interface CustomerDAO {

    Customer findById(Long id);

    List<Customer> findAll();

    void save(Customer customer);

    void update(Customer customer);

    void delete(Long id);
}

