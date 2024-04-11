import java.time.LocalDateTime;
public class PurchasingDetails {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private String billingAddress;
    private String cardNumber;
    private String cardExpiryDate;
    private String cvv;
    private String paymentMethod;
    private LocalDateTime orderDate;
    private double orderTotal;
    private String orderStatus;
    private String shippingMethod;
    private String shippingTrackingNumber;

    // Constructor
    public PurchasingDetails(String firstName, String lastName, String email, String phoneNumber, String address,
                             String billingAddress, String cardNumber, String cardExpiryDate, String cvv,
                             String paymentMethod, LocalDateTime orderDate, double orderTotal, String orderStatus,
                             String shippingMethod, String shippingTrackingNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.billingAddress = billingAddress;
        this.cardNumber = cardNumber;
        this.cardExpiryDate = cardExpiryDate;
        this.cvv = cvv;
        this.paymentMethod = paymentMethod;
        this.orderDate = orderDate;
        this.orderTotal = orderTotal;
        this.orderStatus = orderStatus;
        this.shippingMethod = shippingMethod;
        this.shippingTrackingNumber = shippingTrackingNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
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

    public String getShippingMethod() {
        return shippingMethod;
    }

    public String getShippingTrackingNumber() {
        return shippingTrackingNumber;
    }

    // Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public void setShippingTrackingNumber(String shippingTrackingNumber) {
        this.shippingTrackingNumber = shippingTrackingNumber;
    }

    // Method to calculate total cost
    public double calculateTotalCost() {
        // TODO: Add logic to calculate total cost based on the orderTotal
        return orderTotal;
    }

    // Method to validate credit card details
    public boolean validateCardDetails() {
        // TODO: Add logic to validate card details (e.g., card number, expiry date, CVV)
        return true; // Placeholder return value
    }

    // Method to format address
    public String formatAddress() {
        // TODO: Add logic to format address
        return address; // Placeholder return value
    }

    // Method to update order status
    public void updateOrderStatus(String newStatus) {
        this.orderStatus = newStatus;
    }

    // Method to generate order confirmation
    public String generateOrderConfirmation() {
        return "Order has been confirmed"; // Placeholder return value
    }

    // Method to track shipment
    public String trackShipment() {
        // TODO: Add logic to track shipment using shipping tracking number
        return "Shipment tracking information"; // Placeholder return value
    }

    // Method to verify payment
    public boolean verifyPayment() {
        // TODO: Add logic to verify payment status
        return true; // Placeholder return value
    }

    // Method to add additional notes
    public void addAdditionalNotes(String notes) {
        // TODO: Add logic to add additional notes
    }

    // Method to retrieve order details
    public String retrieveOrderDetails() {
        // TODO: Add logic to retrieve detailed order information
        return "Order details"; // Placeholder return value
    }

    // Method to cancel order
    public void cancelOrder() {
        this.orderStatus = "Cancelled";
    }
}
