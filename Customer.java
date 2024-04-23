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
}
