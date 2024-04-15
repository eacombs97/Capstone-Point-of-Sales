import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// Customer class
public class Customer {
        private int customerId;
        private String firstName;
        private String lastName;
        private String email;
        private String phone;
        private String address;
        private String password;

        //private List<Product> shoppingCart; // List to store products in the shopping cart
        //private List<Order> orders; // List to store customer orders

        // Constructor
        public Customer(int customerId, String firstName, String lastName, String email, String phone, String address) {
            this.customerId = customerId;
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.phone = phone;
            this.address = address;
            //this.orders = new ArrayList<>(); // Initialize the list of customer orders
        }

        // Getters and setters
        public int getCustomerId() {
            return customerId;
        }

        public void setCustomerId(int customerId) {
            this.customerId = customerId;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String address) {
            this.password = password;
        }

        // Method to generate a unique customer ID
        private String generateCustomerId() {
            // Generate a random UUID
            return UUID.randomUUID().toString();
        }

        // Method to register a new customer
        public void register() {
            // TODO: Replace with OAuth2.0 service to validate email and password
            // TODO: Ensure information is updated in the database from the **Database Team**
            System.out.println("Customer registered successfully!");
        }

        // Method to update customer profile
        public void updateProfile(String firstName, String lastName, String email, String password, String address) {
            // TODO: Replace with OAuth2.0 service to validate email and password
            // Validate email and password
            boolean isEmailValid = isValidEmail(email);
            boolean isPasswordValid = isValidPassword(password);
            if (!isEmailValid && !isPasswordValid) {
                System.out.println("Invalid email and password format. Please provide valid email and a strong password.");
                return;
            }

            if (!isEmailValid) {
                System.out.println("Invalid email format. Please provide a valid email address.");
                return;
            }

            if (!isPasswordValid) {
                System.out.println("Invalid password format. Please provide a strong password.");
                return;
            }
            // TODO: Ensure information is updated in the database from the **Database Team**
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.password = password;
            this.address = address;
            System.out.println("Customer profile updated successfully!");
        }
        // Method to validate email format
        private boolean isValidEmail(String email) {
            // Simple email validation format, thanks Google
            return email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
        }
        // Method to validate password strength
        private boolean isValidPassword(String password) {
            // Check if password length is at least 8 characters
            if (password.length() < 8) {
                return false;
            }

            // Check if password contains at least one uppercase letter
            if (!password.matches(".*[A-Z].*")) {
                return false;
            }

            // Check if password contains at least one lowercase letter
            if (!password.matches(".*[a-z].*")) {
                return false;
            }

            // Check if password contains at least one digit
            if (!password.matches(".*\\d.*")) {
                return false;
            }

            // Check if password contains at least one special character
            if (!password.matches(".*[!@#$%^&*()-_=+\\\\|\\[{\\]};:'\",<.>/?].*")) {
                return false;
            }

            return true;
        }

        // Method to change customer password
        public void forgotPassword(String newPassword) {
            // TODO: Perform validation checks on the new password (e.g., strength requirements)
            // Validate password
            boolean isPasswordValid = isValidPassword(password);
            if (!isPasswordValid) {
                System.out.println("Invalid password format. Please provide a strong password.");
                return;
            }

            // TODO: Update the customer's password in the database or perform other persistence operations
            this.password = newPassword;
            // Update other attributes...
            System.out.println("Password changed successfully!");
        }
/**
        // Method to add a product to the shopping cart
        public void addToCart(Product product) {
            shoppingCart.add(product);
            System.out.println(product.getName() + " added to the shopping cart.");
        }

        // Method to remove a product from the shopping cart
        public void removeFromCart(Product product) {
            if (shoppingCart.contains(product)) {
                shoppingCart.remove(product);
                System.out.println(product.getName() + " removed from the shopping cart.");
            } else {
                System.out.println(product.getName() + " is not in the shopping cart.");
            }
        }

        // Method to view the contents of the shopping cart
        public void viewCart() {
            if (shoppingCart.isEmpty()) {
                System.out.println("Your shopping cart is empty.");
            } else {
                System.out.println("Shopping Cart Contents:");
                for (Product product : shoppingCart) {
                    System.out.println("- " + product.getName() + " ($" + product.getPrice() + ")");
                }
            }
        }

        // Method to simulate the checkout process
        public void checkout() {
            if (shoppingCart.isEmpty()) {
                System.out.println("Your shopping cart is empty. Please add items before checkout.");
                return;
            }

            // Perform checkout process (e.g., calculate total, process payment, update inventory, etc.)
            double totalAmount = calculateTotal();

            // Display checkout summary
            System.out.println("Checkout Summary:");
            System.out.println("Total Amount: $" + totalAmount);
            System.out.println("Shipping Address: " + address);

            // Clear the shopping cart after checkout
            shoppingCart.clear();

            System.out.println("Thank you for your purchase! Your order has been placed.");
        }

        // Method to calculate the total amount of the items in the shopping cart
        private double calculateTotal() {
            double totalAmount = 0;
            for (Product product : shoppingCart) {
                totalAmount += product.getPrice();
            }
            return totalAmount;
        }

        // Method to place an order
        public void placeOrder(List<Product> products) {
            // Create a new order
            Order order = new Order(this, products);
            // Add the order to the list of customer's orders
            orders.add(order);
            System.out.println("Order placed successfully!");
        }

        // Method to get the list of orders
        public List<Order> getOrders() {
            return orders;
        }

        // Method to view orders
        public void viewOrders() {
            if (orders.isEmpty()) {
                System.out.println("No orders available for this customer.");
            } else {
                System.out.println("Orders for Customer: " + firstName + " " + lastName);
                for (Order order : orders) {
                    System.out.println("Order ID: " + order.getOrderId());
                    System.out.println("Order Date: " + order.getOrderDate());
                }
            }
        }

        // Method to view order details
        public void viewOrderDetails(String orderId) {
            Order order = findOrderById(orderId);
            if (order != null) {
                System.out.println("Order ID: " + order.getOrderId());
                System.out.println("Order Date: " + order.getOrderDate());
                System.out.println("Products:");
                for (Product product : order.getProducts()) {
                    System.out.println("- " + product.getName() + " ($" + product.getPrice() + ")");
                }
                System.out.println("Total Amount: $" + order.getTotalAmount());
                // Add other order details as needed
            } else {
                System.out.println("Order with ID " + orderId + " not found.");
            }
        }

        // Method to find an order by ID
        private Order findOrderById(String orderId) {
            for (Order order : orders) {
                if (order.getOrderId().equals(orderId)) {
                    return order;
                }
            }
            return null; // Order not found
        }

        // Method to cancel an order
        public void cancelOrder(String orderId) {
            Order order = findOrderById(orderId);
            if (order != null) {
                // Remove the order from the list of customer's orders
                orders.remove(order);
                System.out.println("Order with ID " + orderId + " has been canceled.");
            } else {
                System.out.println("Order with ID " + orderId + " not found. Unable to cancel.");
            }
        }
 **/
}
