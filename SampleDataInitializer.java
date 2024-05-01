package com.pos.pointofsaleswebapp;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SampleDataInitializer implements CommandLineRunner {

    @Autowired
    private DataSource dataSource;

    @Override
    public void run(String... args) throws Exception {
        
        Connection connection = null;
        try {

         connection = dataSource.getConnection(); 
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet tables = metaData.getTables(null, null, "mock_products", null);
            if (!tables.next()) {
                // The "products" table does not exist, create it
                createProductsTable(connection);
            }
        

        // Insert sample data into the "products" table
        insertSampleData(connection);
    }catch (SQLException e) {
        // Handle any SQL exceptions
        throw new RuntimeException("Failed to initialize sample data", e);
    } finally {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                // Handle any SQL exceptions
                throw new RuntimeException("Failed to close connection", e);
            }
        }
    }
}
    

    private void createProductsTable(Connection connection) throws SQLException {
        String sql = "CREATE TABLE mock_products ("
                + "id INT AUTO_INCREMENT PRIMARY KEY,"
                + "name VARCHAR(255) NOT NULL,"
                + "price DECIMAL(10, 2) NOT NULL"
                + ")";
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        }
    
}
    private void insertSampleData(Connection connection) throws SQLException {
        String[] sampleProducts = {
            "('Product 1', 10.99)",
            "('Product 2', 15.99)",
            "('Product 3', 20.49)"
        };
    
        String sql = "INSERT INTO products (name, price) VALUES ";
    
        // Build the SQL statement with sample data
        StringBuilder sqlBuilder = new StringBuilder(sql);
        for (int i = 0; i < sampleProducts.length; i++) {
            if (i > 0) {
                sqlBuilder.append(", ");
            }
            sqlBuilder.append(sampleProducts[i]);
        }
    
        // Execute the SQL statement to insert sample data
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sqlBuilder.toString());
        } catch (SQLException e) {
            // Handle any SQL exceptions
            throw new SQLException("Failed to insert sample data into products table", e);
        }
    }
    

}

