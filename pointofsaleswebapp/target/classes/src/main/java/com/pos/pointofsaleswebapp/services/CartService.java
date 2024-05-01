package com.pos.pointofsaleswebapp.services;

import java.util.ArrayList;
import java.util.Iterator;
//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.pos.pointofsaleswebapp.model.Cart;
import com.pos.pointofsaleswebapp.model.OrderItem;

import jakarta.servlet.http.HttpSession;
@Service
public class CartService {
    @Autowired
    private HttpSession session;
    public List<OrderItem> getCartItems() {
        // Retrieve the cart items from the session
        @SuppressWarnings("unchecked")
        List<OrderItem> cartItems = (List<OrderItem>) session.getAttribute("cartItems");

        // If the attribute is not found or is not of the expected type, return an empty list
        if (cartItems == null) {
            cartItems = new ArrayList<>();
            session.setAttribute("cartItems", cartItems);
        }

        return cartItems;
    }

    public void addToCart(OrderItem orderItem, int quantity) {
      
             // Retrieve the cart items from the session
             List<OrderItem> cartItems = getCartItems();

             // Check if the product is already in the cart
             for (OrderItem item : cartItems) {
                 if (item.getProduct().getId() == orderItem.getProduct().getId()) {
                     // If the product is already in the cart, update the quantity
                     item.setQuantity(item.getQuantity());
                     // Update the session attribute
                     session.setAttribute("cartItems", cartItems);
                     return; // Exit the method after updating the quantity
                 }
             }
     
             // If the product is not in the cart, add it as a new item
             cartItems.add(orderItem);
             // Update the session attribute
             session.setAttribute("cartItems", cartItems);
         }
    
         public void removeFromCart(long productId) {
            // Retrieve the cart items from the session
            List<OrderItem> cartItems = getCartItems();
    
            // Iterate through the cart items to find and remove the item with the given productId
            Iterator<OrderItem> iterator = cartItems.iterator();
            while (iterator.hasNext()) {
                OrderItem item = iterator.next();
                if (item.getProduct().getId() == productId) {
                    iterator.remove();
                    break; // Exit the loop after removing the item
                }
            }
    
            // Update the session attribute
            session.setAttribute("cartItems", cartItems);
        }
      

    public double getTotalPrice() {
        List<OrderItem> cartItems = getCartItems();
        double totalPrice = 0.0;
        
        for (OrderItem orderItem : cartItems) {
            
            ;
            totalPrice += orderItem.getProduct().getPrice()* orderItem.getQuantity();
        }
        return totalPrice;
    }


    }



