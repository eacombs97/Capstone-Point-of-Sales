public class Employee {
    private int employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private String role;
    private String department;  // I don't know if this is necessary, we're all in the same department lol

    // Constructor
    public Employee(int employeeId, String firstName, String lastName, String email, String phone, String role, String department) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.department = department;
    }

    // Getters and setters
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String address) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    // Method to update employee profile
    public void updateProfile(String firstName, String lastName, String email, String password) {
        // TODO: Replace with OAuth2.0 service to validate email and password
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
        // TODO: Ensure information is updated in the database or other persistence operations
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
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

    // Method to change employee password
    public void forgotPassword(String newPassword) {
        // TODO: TODO: Replace with OAuth2.0 service to validate email and password
        // Validate password
        boolean isPasswordValid = isValidPassword(password);
        if (!isPasswordValid) {
            System.out.println("Invalid password format. Please provide a strong password.");
            return;
        }

        // TODO: Ensure information is updated in the database or other persistence operations
        this.password = newPassword;
        // Update other attributes...
        System.out.println("Password changed successfully!");
    }
}
