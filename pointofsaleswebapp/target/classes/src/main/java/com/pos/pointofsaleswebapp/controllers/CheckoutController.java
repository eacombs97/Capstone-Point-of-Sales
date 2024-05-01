package com.pos.pointofsaleswebapp.controllers;


import java.util.List;
//import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


//import com.pos.pointofsaleswebapp.model.Cart;
import com.pos.pointofsaleswebapp.model.Customer;
import com.pos.pointofsaleswebapp.model.Order;
import com.pos.pointofsaleswebapp.model.OrderItem;
//import com.pos.pointofsaleswebapp.repositories.JdbcOrderDAO;
import com.pos.pointofsaleswebapp.services.CartService;
import com.pos.pointofsaleswebapp.services.OrderService;

import jakarta.servlet.http.HttpSession;



@Controller
@RequestMapping("/checkout")
public class CheckoutController{
    private final OrderService orderService;
    private final CartService cartService;
    private static final Logger logger = LoggerFactory.getLogger(CheckoutController.class);

public CheckoutController(OrderService orderService,CartService cartService) {
        this.orderService = orderService;
        this.cartService  = cartService;
        
    }

     @GetMapping()
    public String showCheckoutForm(Model model, HttpSession session) {
        List<OrderItem> cartItems = cartService.getCartItems();
        double totalPrice = cartService.getTotalPrice();
        model.addAttribute("cartItems", cartItems);
        model.addAttribute("totalPrice", totalPrice);
       /* *if (!model.containsAttribute("customer")) {
            model.addAttribute("customer", new Customer());
        } */
        return "checkout";
    }

    @PostMapping("/placeOrder")
public String processCheckout(@ModelAttribute Customer customer,
@RequestParam("street") String street,
@RequestParam("zip") String zip,
@RequestParam("state") String state,
                              HttpSession session) {

    
    // Set the address for the customer     
    String address = street + ", " + zip + ", " + state;
    
    customer.setAddress(address);
    String customerId = customer.generateCustomerId();
    customer.setCustomerId(customerId);
   session.setAttribute("customer", customer);
            //logger info to ensure customer created
    logger.info("Received customer: {}", customer);
    logger.info("Street: {}, Zip: {}, State: {}", street, zip, state);
    // Retrieve Cart Items
    @SuppressWarnings("unchecked")
    List<OrderItem> cartItems = (List<OrderItem>) session.getAttribute("cartItems");


    if (cartItems == null || cartItems.isEmpty()) {
        // Handle empty cart scenario
        return "redirect:/cart/view"; // Redirect to cart page with error message
    }


    // Create Order Object
    Order order = new Order();

    

    // Set Cart and Total Price for Order
    order.setCart(cartItems);
    order.setTotalPrice(cartService.getTotalPrice());



    
    orderService.createOrder(order, session);
    session.setAttribute("order", order);
    
    return "payment";

}
@GetMapping("/payment")
public String showPaymentPage() {
    return "payment"; 
}

@PostMapping("/processPayment")
public String processPayment(@RequestParam("cardNumber") String cardNumber, 
                             HttpSession session,Model model) {
    
    boolean paymentSuccessful = simulatePaymentProcessing(cardNumber);

    if (!paymentSuccessful) {
        // Set error message in the model
        model.addAttribute("errorMessage", "Payment failed. Please try again.");

    }
    // Payment successful, proceed with creating the order
    return "redirect:/order/confirmation";
}


private boolean simulatePaymentProcessing(String cardNumber) {
    // TODO Auto-generated method stub
    return cardNumber.startsWith("1234");
}

}


