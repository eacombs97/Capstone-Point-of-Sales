package com.pos.pointofsaleswebapp.repositories;

import org.springframework.stereotype.Repository;

import com.pos.pointofsaleswebapp.model.Order;

import java.util.List;

@Repository
public class OrderRepository {

    private final JdbcRepository<Order> jdbcRepository;

    public OrderRepository(JdbcRepository<Order> jdbcRepository) {
        this.jdbcRepository = jdbcRepository;
    }

    public List<Order> findAll() {
        return jdbcRepository.findAll("orders", Order.class);
    }

    public Order findById(Long id) {
        return jdbcRepository.findById("orders", id, Order.class);
    }

    // Other methods specific to Order entity can be added here
}
