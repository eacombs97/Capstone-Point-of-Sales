package com.pos.pointofsaleswebapp.controllers;

import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.pos.pointofsaleswebapp.model.OrderItem;
import com.pos.pointofsaleswebapp.model.Product;
//import com.pos.pointofsaleswebapp.model.OrderItem;
import com.pos.pointofsaleswebapp.services.CartService;
import com.pos.pointofsaleswebapp.services.ProductService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;
    @Autowired
    private ProductService productService; // Assuming you have a ProductService to fetch product details

    public CartController(CartService cartService, ProductService productService){
        this.cartService = cartService;
        this.productService = productService;
    }

    @GetMapping("/add")
    public String showAddToCartForm(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "addToCart"; // Return the name of the view for adding to cart
    }

    @PostMapping("/add")
    public String addToCart(@RequestParam("productId") long productId, @RequestParam("quantity") int quantity) {
        // Add the item to the cart
        Product product = productService.getProductById(productId);
        OrderItem orderItem = new OrderItem(product,quantity);
        cartService.addToCart(orderItem,quantity);

        // Redirect to the cart page or any other appropriate page
        return "redirect:/cart/view?productId=" + productId + "&quantity=" + quantity;
    }

    @GetMapping("/view")
    public String viewCart(@RequestParam(value = "productId", required = false) Long productId,
                           @RequestParam(value = "quantity", required = false) Integer quantity,
                           Model model, HttpSession session) {
        // Check if productId and quantity are provided
        if (productId != null && quantity != null) {
            // Add the new item to the cart based on productId and quantity
            Product product = productService.getProductById(productId);
            OrderItem orderItem = new OrderItem(product, quantity);
            cartService.addToCart(orderItem, quantity);
        }
    
        // Retrieve the cart items and total price
        List<OrderItem> cartItems = cartService.getCartItems();
        double totalPrice = cartService.getTotalPrice();
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String formattedTotalPrice = decimalFormat.format(totalPrice);
        // Add cart items and total price to the model
        model.addAttribute("cartItems", cartItems);
        model.addAttribute("totalPrice", formattedTotalPrice);
        session.setAttribute("cartItems", cartItems);
        // Return the name of the view for viewing the cart
        return "cart";
    }
    @PostMapping("/remove")
    public String removeFromCart(@RequestParam("productId") long productId) {
        // Remove the item with the given productId from the cart
        cartService.removeFromCart(productId);

        // Redirect to the cart view page
        return "redirect:/cart/view";
    }
    
}

