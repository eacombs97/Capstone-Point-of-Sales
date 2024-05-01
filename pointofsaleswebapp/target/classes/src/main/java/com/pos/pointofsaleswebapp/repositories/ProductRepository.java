package com.pos.pointofsaleswebapp.repositories;

import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pos.pointofsaleswebapp.model.Product;

@Repository
public class ProductRepository {

    private final JdbcRepository<Product> jdbcRepository;

    
    public ProductRepository(JdbcRepository<Product> jdbcRepository) {
        this.jdbcRepository = jdbcRepository;
    }

    public List<Product> findAll() {
        return jdbcRepository.findAll("products", Product.class);
    }

    public Product findById(Long id) {
        return jdbcRepository.findById("products", id, Product.class);
    }

    // Other methods specific to Product entity can be added here
}

