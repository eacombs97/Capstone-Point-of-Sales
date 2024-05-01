package com.pos.pointofsaleswebapp.services;

import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos.pointofsaleswebapp.model.Customer;
import com.pos.pointofsaleswebapp.model.Order;
import com.pos.pointofsaleswebapp.model.OrderItem;
import com.pos.pointofsaleswebapp.repositories.JdbcOrderDAO;

import jakarta.servlet.http.HttpSession;
@Service
public class OrderService {

    private final JdbcOrderDAO jdbcOrderDAO;
    
    public OrderService (JdbcOrderDAO jbdcOrderDAO){
        this.jdbcOrderDAO = jbdcOrderDAO;
    }
    public Order createOrder(Order orderDetails, HttpSession session) {
        Customer customer = (Customer) session.getAttribute("customer");
        if (customer == null) {
            throw new IllegalArgumentException("Customer is null");
        }
        if (orderDetails == null) {
            throw new IllegalArgumentException("Order details are null");
        }
        List<OrderItem> orderItems = orderDetails.getCart();
        double totalPrice = calculateTotalPrice(orderItems);
        String customerId = customer.getCustomerId();
        String orderId = orderDetails.getOrderId();
        if (orderItems.isEmpty()) {
            throw new IllegalArgumentException("Cart is empty");
        }
        session.setAttribute("customer", customer);
        return new Order(customerId, orderId, orderItems, totalPrice);
    }
    public void saveOrder(Order order){
        jdbcOrderDAO.saveOrder(order);
    }
    

    private double calculateTotalPrice(List<OrderItem> orderItems) {
        double totalPrice = 0.0;
        for (OrderItem item : orderItems) {
            double productPrice = item.getProduct().getPrice();
            totalPrice+= productPrice * item.getQuantity();
        }
        return totalPrice;
    }
}
