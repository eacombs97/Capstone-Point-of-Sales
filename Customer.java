import java.util.UUID;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Customer class
public class Customer {
        private int customerId;
        private String firstName;
        private String lastName;
        private String email;
        private String phone;
        private String address;
        private String password;

        // Constructor
        public Customer(int customerId, String firstName, String lastName, String email, String phone, String address) {
            this.customerId = customerId;
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.phone = phone;
            this.address = address;
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
}
