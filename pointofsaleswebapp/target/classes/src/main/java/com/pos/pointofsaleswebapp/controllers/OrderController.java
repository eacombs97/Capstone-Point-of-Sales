package com.pos.pointofsaleswebapp.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import com.pos.pointofsaleswebapp.model.Customer;
import com.pos.pointofsaleswebapp.model.Order;
import com.pos.pointofsaleswebapp.services.OrderService;

import jakarta.servlet.http.HttpSession;

import java.util.*;


@Controller

@RequestMapping("/order")
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
    private final OrderService orderService;
    
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }
 @GetMapping("/confirmation")
    public String showOrderConfirmation(Model model,HttpSession session) {
              // Add necessary model attributes
              Customer customer = (Customer) session.getAttribute("customer");
              if (customer == null) {
                // Log an error or throw an exception if customer is null
                logger.error("Customer object is null");
                // You can handle this error gracefully, e.g., redirect to an error page
                return "error"; 
            }
              String customerName = customer.getName();
              String customerEmail = customer.getEmail();
              String confirmationNumber= generateConfirmationNumber();
              // Retrieve order object from session
              Order order = (Order) session.getAttribute("order");
              String orderNumber = order.getOrderId();
              model.addAttribute("customerName", customerName);
              model.addAttribute("customerEmail", customerEmail);
              model.addAttribute("orderNumber", orderNumber);
        model.addAttribute("confirmationNumber", confirmationNumber);
        return "confirmation"; // Make sure this matches the template file name
    }
  
    @PostMapping("/checkout/saveOrder")
    public String processCheckout(@RequestBody Order order) {
        orderService.saveOrder(order);
        
        
        return "Order placed successfully!";
    }
    

    private String generateConfirmationNumber() {
        Random random = new Random();
        int min = 100000; // Minimum 6-digit number
        int max = 999999; // Maximum 6-digit number
        int randomNumber = random.nextInt(max - min + 1) + min;
        return String.valueOf(randomNumber);
    }
 
}



