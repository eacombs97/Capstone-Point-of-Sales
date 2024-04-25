import java.time.LocalDateTime;
import java.util.UUID;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Customer class
public class Customer {
        private String customerId;
        private String firstName;
        private String lastName;
        private String email;
        private String phone;
        private String address;
        private String password;
        private String billingAddress;
        private String cardNumber;
        private String cardExpiryDate;
        private String cvv;
        private String paymentMethod;
        private LocalDateTime orderDate;
        private double orderTotal;
        private String orderStatus;

        // Constructor
        public Customer(String firstName, String lastName, String email, String phone, String address) {
            this.customerId = UUID.randomUUID().toString();
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.phone = phone;
            this.address = address;
        }

        // Getters and setters
        public String getCustomerId() {
            return customerId;
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

        public void setPassword(String password) {
            this.password = password;
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
            // Check if password is null
            if (password == null) {
                System.out.println("Password cannot be null.");
                return false;
            }
            // Check if password length is at least 8 characters
            if (password.length() < 8) {
                System.out.println("Password must be at least 8 characters long.");
                return false;
            }

            // Check if password contains at least one uppercase letter
            if (!password.matches(".*[A-Z].*")) {
                System.out.println("Password must contain at least one uppercase letter.");
                return false;
            }

            // Check if password contains at least one lowercase letter
            if (!password.matches(".*[a-z].*")) {
                System.out.println("Password must contain at least one lowercase letter.");
                return false;
            }

            // Check if password contains at least one digit
            if (!password.matches(".*\\d.*")) {
                System.out.println("Password must contain at least one digit.");
                return false;
            }

            // Check if password contains at least one special character
            if (!password.matches(".*[!@#$%^&*()-_=+\\\\|\\[{\\]};:'\",<.>/?].*")) {
                System.out.println("Password must contain at least one special character.");
                return false;
            }

            return true;
        }

        // Method to change customer password
        public void forgotPassword(String newPassword) {
            // Validate password
            if (isValidPassword(newPassword)) {
                System.out.println("Password changed successfully!");
                this.password = newPassword;
                return;
            }

            // TODO: Update the customer's password in the database or perform other persistence operations
            System.out.println("Invalid password format. Please provide a strong password.");
        }

    public String getBillingAddress() {
        return billingAddress;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardExpiryDate() {
        return cardExpiryDate;
    }

    public String getCvv() {
        return cvv;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setCardExpiryDate(String cardExpiryDate) {
        this.cardExpiryDate = cardExpiryDate;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    // Method to calculate total cost
    public double calculateTotalCost() {
        // TODO: Add logic to calculate total cost based on **Database Team**
        return orderTotal;
    }

    // Method to validate credit card details
    public boolean validateCardDetails() {
        // Validate card number
        if (isValidCardNumber(cardNumber)) {
            return false;
        }

        // Validate card expiry date
        if (isValidExpiryDate(cardExpiryDate)) {
            return false;
        }

        // Validate CVV
        if (isValidCVV(cvv)) {
            return false;
        }

        return true;
    }

    // Helper method to validate card number
    private boolean isValidCardNumber(String cardNumber) {
        // Logic to validate card number
        String cardNumberRegex = "^(\\d{4}-){3}\\d{4}$";

        // Check if address matches the format
        if (!cardNumber.matches(cardNumberRegex)) {
            return true;
        }

        return false;
    }

    // Helper method to validate card expiry date
    private boolean isValidExpiryDate(String expiryDate) {
        // Logic to validate expiry date
        String expiryDateRegex = "^(0[1-9]|1[0-2])/[0-9]{2}$";

        // Check if address matches the format
        if (!expiryDate.matches(expiryDateRegex)) {
            return true;
        }

        return false;
    }

    // Helper method to validate CVV
    private boolean isValidCVV(String cvv) {
        // Logic to validate CVV
        String cvvRegex = "^[0-9]{3}$";

        // Check if address matches the format
        if (!cvv.matches(cvvRegex)) {
            return true;
        }

        return false;
    }

    // Method to update order status
    public void updateOrderStatus(String newStatus) {
        this.orderStatus = newStatus;
    }

    // Method to generate order confirmation
    public String generateOrderConfirmation() {
        return "Order has been confirmed"; // Placeholder return value
    }

    // Method to verify payment
    public String verifyPayment() {
        // Validate card number
        if (isValidCardNumber(cardNumber)) {
            return "Payment failed";
        }

        // Validate card expiry date
        if (isValidExpiryDate(cardExpiryDate)) {
            return "Payment failed";
        }

        // Validate CVV
        if (isValidCVV(cvv)) {
            return "Payment failed";
        }

        return "Payment successful";
    }

    // Method to retrieve order details
    public String retrieveOrderDetails(Customer customer) {
        return "Order details...\n" + "Customer: " + customer.getFirstName() + " " + customer.getLastName() + "\n"
                + "Order date: " + orderDate + "\n" + "Order total: " + orderTotal + "\n" + "Order status: " + orderStatus;
    }
}
