import java.util.ArrayList;
import java.util.List;

public class Product {
    private static List<Product> productList = new ArrayList<>();
    private String productId;
    private String name;
    private double price;
    private String description;

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
