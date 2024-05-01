package com.pos.pointofsaleswebapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos.pointofsaleswebapp.model.Product;
import com.pos.pointofsaleswebapp.repositories.ProductRepository;
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    // Assuming products are stored in memory

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        //return productRepository.findAll();
        List<Product> products = productRepository.findAll();
        
        // If the database query returns an empty result, return a list of sample items
        if (products.isEmpty()) {
            return getSampleProducts();
        }
        
        return products;
    }
    
    // Method to return a list of sample products
    private List<Product> getSampleProducts() {
        List<Product> sampleProducts = new ArrayList<>();
        
        // Add sample products to the list
        sampleProducts.add(new Product(1L, "Moleskin Note Book", 9.99,"/images/image.jpeg"));
        sampleProducts.add(new Product(2L, "Hamilton Beach Toaster", 19.99, "images/HamiltonBeachToaster.jpeg"));
        sampleProducts.add(new Product(3L, "Lenovo Think System", 149.99,"/images/LenovoThinkSystem.jpeg"));
        
        return sampleProducts;
    }

    

   

    public Product getProductById(Long productId) {
         // Return null if product with given ID is not found
         Product product = productRepository.findById(productId);
         product.getId();
         return product;

    }

    public double getProductPrice(Long productId) {
        // Retrieve the product from the database using the productId
        Product product = productRepository.findById(productId);
        
        // Check if the product exists and return its price
        if (product != null) {
            return product.getPrice();
        } else {
            // If product not found, return a default price or handle the scenario as needed
            return 0.0; // Return 0 as default price
        }

}
}
