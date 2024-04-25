import java.util.ArrayList;
import java.util.List;
import com.microsoft.aad.msal4j.*;
/**
 * Main Class for the Accounts Application
 * @author Skyler Ireland
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) throws Exception {
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

        // This block of code demonstrates the use of encryption and decryption methods
        customer1.setCardNumber("808090706072");
        customer1.setCardNumber(Encryption.encrypt(customer1.getCardNumber())); // Encryption that sets the card number to an encrypted value
        System.out.println("Encrypted Card Number: " + customer1.getCardNumber()); // Prints the encrypted card number
        customer1.setCardNumber(Encryption.decrypt(customer1.getCardNumber())); // Decryption that sets the card number to a decrypted value
        System.out.println("Decrypted Card Number: " + customer1.getCardNumber()); // Prints the decrypted card number
        customer1.setCardExpiryDate("09/25");
        customer1.setCardExpiryDate(Encryption.encrypt(customer1.getCardExpiryDate())); // Encryption that sets the expiry date to an encrypted value
        System.out.println("Encrypted Expiry Date: " + customer1.getCardExpiryDate()); // Prints the encrypted expiry date
        customer1.setCardExpiryDate(Encryption.decrypt(customer1.getCardExpiryDate())); // Decryption that sets the expiry date to a decrypted value
        System.out.println("Decrypted Expiry Date: " + customer1.getCardExpiryDate()); // Prints the decrypted expiry date
        customer1.setCvv("1234");
        customer1.setCvv("123");
        customer1.setCvv(Encryption.encrypt(customer1.getCvv())); // Encryption that sets the CVV to an encrypted value
        System.out.println("Encrypted CVV: " + customer1.getCvv()); // Prints the encrypted CVV
        customer1.setCvv(Encryption.decrypt(customer1.getCvv())); // Decryption that sets the CVV to a decrypted value
        System.out.println("Decrypted CVV: " + customer1.getCvv()); // Prints the decrypted CVV
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