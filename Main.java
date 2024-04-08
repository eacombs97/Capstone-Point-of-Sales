/**
 * Main Class for the Accounts Application
 * @author Skyler Ireland
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Customer customer1 = new Customer(1, "John", "Doe", "HkS9z@example.com", "555-555-5555", "123 Main St");
        Employee employee1 = new Employee(1, "Skyler", "Ireland", "irelands3139@forsythtech.edu", "336-276-4999", "Programmer", "Information Technology");
        Employee employee2 = new Employee(2, "Emily", "Combs", "HkS9z@forsythtech.edu", "555-555-5555", "Programmer", "Information Technology");
        Employee employee3 = new Employee(3, "Kaira", "Gaines", "HkS9z@forsythtech.edu", "555-555-5555", "Programmer", "Information Technology");
        Employee employee4 = new Employee(4, "Marvin", "Araya", "HkS9z@forsythtech.edu", "555-555-5555", "Programmer", "Information Technology");
    }
}