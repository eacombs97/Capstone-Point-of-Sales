package com.pos.pointofsaleswebapp.services;

import java.util.ArrayList;
import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.pos.pointofsaleswebapp.model.OrderItem;
import com.pos.pointofsaleswebapp.model.Product;
@Service
public class OrderItemService {
   

    private static final List<OrderItem> orderItems = new ArrayList<>();
    
  

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }


 
    public double getProudctPrice(Product product){
        return product.getPrice();
    }
}

