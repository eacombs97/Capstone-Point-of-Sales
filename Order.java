import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private String orderId;
    private Customer customer;
    private List<Product> products;
    private Date orderDate;
    private double totalAmount;

    // Constructor
    public Order(Customer customer, List<Product> products) {
        this.orderId = generateOrderId(); // Generate a unique order ID
        this.customer = customer;
        this.products = products;
        this.orderDate = new Date(); // Current date and time
        calculateTotalAmount();
    }


    // Method to generate a unique order ID
    private String generateOrderId() {
        // Logic to generate a unique order ID (e.g., using UUID)
        // For simplicity, let's assume it's just a concatenation of customer ID and current timestamp :)
        return customer.getCustomerId() + "-" + System.currentTimeMillis();
    }
    public String getOrderId() {
        return orderId;
    }

    // Method to calculate the total amount of the order
    private void calculateTotalAmount() {
        totalAmount = 0;
        for (Product product : products) {
            totalAmount += product.getPrice();
        }
    }

    public String getTotalAmount() {
        return String.format("%.2f", totalAmount);
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public Product[] getProducts() {
        return products.toArray(new Product[0]);
    }
}
