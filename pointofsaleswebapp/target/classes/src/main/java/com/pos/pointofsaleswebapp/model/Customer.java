package com.pos.pointofsaleswebapp.model;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
// Customer class
public class Customer implements Serializable  {
    private static final long serialVersionUID = 1L;
        private String customerId;
        private String firstName;
        private String lastName;
        private String street; // New field for street
        private String zip;    // New field for zip
        private String state;  // New field for state
        private String email;
        private String phone;
        private String address;
        private String password;
    private String name;

        // Constructor
        @AllArgsConstructor
    public Customer(String customerId, String firstName, String lastName, String email, String phone, String address) {
            this.customerId = generateCustomerId();
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.phone = phone;
            this.address = address;
        }
       public Customer(String customerID, String name,String address, String email, String phone ){
        this.customerId = customerID;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        
       }

        public Customer() {
            //TODO Auto-generated constructor stub
        }

        // Getters and setters
        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId ) {
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
    // Getter method for street
    public String getStreet() {
        return street;
    }

    // Setter method for street
    public void setStreet(String street) {
        this.street = street;
    }

    // Getter method for zip
    public String getZip() {
        return zip;
    }

    // Setter method for zip
    public void setZip(String zip) {
        this.zip = zip;
    }

    // Getter method for state
    public String getState() {
        return state;
    }
        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        // Method to generate a unique customer ID
        public String generateCustomerId() {
            // Generate a random UUID
            return UUID.randomUUID().toString();
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
        @Override
        public String toString (){
            return  "Customer{" +
            "id=" +customerId +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", email='" + email + '\'' +
            ", phone='" + phone + '\'' +
            ", address='" + address + '\'' +
            ", password='" + password + '\'' +
            '}';
        }
        public String getName() {
          return name;
        }
        public void setName(String name) {
            // TODO Auto-generated method stub
            this.name = name;
        }
    }

        

