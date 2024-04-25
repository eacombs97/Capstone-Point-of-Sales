import java.util.ArrayList;
import java.util.List;
import com.microsoft.aad.msal4j.*;
/**
 * Main Class for the Accounts Application
 * @author Skyler Ireland
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Customer customer1 = new Customer("John", "Doe", "HkS9z@example.com", "555-555-5555", "123 Main St");
        Employee employee1 = new Employee("Skyler", "Ireland", "irelands3139@forsythtech.edu", "336-276-4999", "Programmer", "Information Technology");
        Employee employee2 = new Employee("Emily", "Combs", "HkS9z@forsythtech.edu", "555-555-5555", "Programmer", "Information Technology");
        Employee employee3 = new Employee("Kaira", "Gaines", "HkS9z@forsythtech.edu", "555-555-5555", "Programmer", "Information Technology");

        customer1.setEmail("john99doe@gmail.com");
        customer1.setPassword("password123");
        customer1.forgotPassword("Sancis1!");
        System.out.println();
        customer1.setAddress("123 Side St");
        customer1.setPhone("555-666-7777");
        customer1.setFirstName("Jake");
        customer1.setLastName("Foe");

        System.out.println("Customer ID: " + customer1.getCustomerId());
        System.out.println("Name: " + customer1.getFirstName() + " " + customer1.getLastName());
        System.out.println("Email: " + customer1.getEmail());
        System.out.println("Password: " + customer1.getPassword());
        System.out.println("Phone: " + customer1.getPhone());
        System.out.println("Address: " + customer1.getAddress());
        System.out.println();

        customer1.updateProfile("Fake", "Joe", "cursed@example.com", "LeHacked69", "111 Dumb St");
        System.out.println();

        System.out.println("Customer ID: " + customer1.getCustomerId());
        System.out.println("Name: " + customer1.getFirstName() + " " + customer1.getLastName());
        System.out.println("Email: " + customer1.getEmail());
        System.out.println("Password: " + customer1.getPassword());
        System.out.println("Phone: " + customer1.getPhone());
        System.out.println("Address: " + customer1.getAddress());
        System.out.println();
        System.out.println();

        employee1.setEmail("irelands5050@forsythtech.edu");
        employee1.setPassword("password123");
        employee1.forgotPassword("Sancis1!");
        System.out.println();
        employee1.setPhone("555-666-7777");
        employee1.setFirstName("Schuyler");
        employee1.setLastName("Eire");

        System.out.println("Employee ID: " + employee1.getEmployeeId());
        System.out.println("Name: " + employee1.getFirstName() + " " + employee1.getLastName());
        System.out.println("Email: " + employee1.getEmail());
        System.out.println("Password: " + employee1.getPassword());
        System.out.println("Phone: " + employee1.getPhone());
        System.out.println();
    }
}