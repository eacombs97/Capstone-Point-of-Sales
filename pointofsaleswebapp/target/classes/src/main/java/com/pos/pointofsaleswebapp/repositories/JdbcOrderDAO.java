package com.pos.pointofsaleswebapp.repositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pos.pointofsaleswebapp.model.Order;
@Repository
public class JdbcOrderDAO implements OrderDAO {

    private final JdbcTemplate jdbcTemplate;

    public JdbcOrderDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void saveOrder(Order order) {
        String sql = "INSERT INTO orders (order_id, order_id, created_at) VALUES (?, ?,?)";
        jdbcTemplate.update(sql, order.getOrderId(), order.getCustomer(),order.getDate());
    }
}
