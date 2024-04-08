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
        // For simplicity, let's assume it's just a concatenation of customer ID and current timestamp
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

class Product {
    private static List<Product> productList = new ArrayList<>();
    private String productId;
    private String name;
    private double price;
    private String description;
    // Other attributes...

    // Constructor
    public Product(String productId, String name, double price, String description) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    // Getter and setter methods for productId
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    // Getter and setter methods for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and setter methods for price
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Getter and setter methods for description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Add a product to the list
    public void addProduct(Product product) {
        productList.add(product);
    }

    // Get the list of products
    public static List<Product> getProductList() {
        return productList;
    }
}
