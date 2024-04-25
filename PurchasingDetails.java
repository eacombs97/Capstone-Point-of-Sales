import java.time.LocalDateTime;
public class PurchasingDetails {
    private String billingAddress;
    private String cardNumber;
    private String cardExpiryDate;
    private String cvv;
    private String paymentMethod;
    private LocalDateTime orderDate;
    private double orderTotal;
    private String orderStatus;


    // Constructor
    public PurchasingDetails(String billingAddress, String cardNumber, String cardExpiryDate, String cvv,
                             String paymentMethod, LocalDateTime orderDate, double orderTotal, String orderStatus) {
        this.billingAddress = billingAddress;
        this.cardNumber = cardNumber;
        this.cardExpiryDate = cardExpiryDate;
        this.cvv = cvv;
        this.paymentMethod = paymentMethod;
        this.orderDate = orderDate;
        this.orderTotal = orderTotal;
        this.orderStatus = orderStatus;
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

    // Method to format address
    public boolean formatAddress() {
        // Regular expression for address format
        String addressRegex = "^[a-zA-Z0-9\\s]*$";

        // Check if address matches the format
        if (!billingAddress.matches(addressRegex)) {
            return false;
        }

        return true;
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
