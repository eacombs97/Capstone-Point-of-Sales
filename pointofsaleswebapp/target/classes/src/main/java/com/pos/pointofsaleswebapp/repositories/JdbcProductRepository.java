package com.pos.pointofsaleswebapp.repositories;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pos.pointofsaleswebapp.model.Product;

public class JdbcProductRepository {

    private static final String URL = "jdbc:mysql://database.bitbuggy.dev:3306/bitbuggy";
    private static final String USERNAME = "pos";
    private static final String PASSWORD = "BitBuggy!!2024?Wh3r3sMyDBA?";

    private static final String CREATE_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS products ("
            + "id INT AUTO_INCREMENT PRIMARY KEY,"
            + "name VARCHAR(255),"
            + "price DECIMAL(10, 2),"
            + "image_url VARCHAR(255)"
            + ")";
    
    private static final String CHECK_TABLE_QUERY = "SHOW TABLES LIKE 'products'";

    private static final String INSERT_SAMPLE_DATA_QUERY = "INSERT INTO sample_products (name, price,image_url) VALUES "
    + "('Hamilton Beach Toaster', 9.99, '/images/HamiltonBeachToaster.jpeg'), "
    + "('Lenovo Think System', 199.99, '/images/LenovoThinkSystem.jpeg'), "
    + "('Moleskine Notebook', 14.99, '/images/image.jpeg')";
    

    private static final String UPDATE_SAMPLE_DATA_QUERY = 
    "UPDATE sample_products SET " +
    "name = CASE " +
    "    WHEN id = 1 THEN 'Hamilton Beach Toaster' " +
    "    WHEN id = 2 THEN 'Lenovo Think System' " +
    "    WHEN id = 3 THEN 'Moleskine Notebook' " +
    "END, " +
    "price = CASE " +
    "    WHEN id = 1 THEN 9.99 " +
    "    WHEN id = 2 THEN 199.99 " +
    "    WHEN id = 3 THEN 14.99 " +
    "END, " +
    "image_url = CASE " +
    "    WHEN id = 1 THEN '/images/HamiltonBeachToaster.jpeg' " +
    "    WHEN id = 2 THEN '/images/LenovoThinkSystem.jpeg' " +
    "    WHEN id = 3 THEN '/images/image.jpeg' " +
    "END " +
    "WHERE id IN (1, 2, 3)";


    private static final String SELECT_ALL_QUERY = "SELECT * FROM products";

    public JdbcProductRepository() {
        initializeDatabase();
        updateSampleData();
    }

    private void initializeDatabase() {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement createTableStatement = connection.prepareStatement(CREATE_TABLE_QUERY);
             PreparedStatement checkTableStatement = connection.prepareStatement(CHECK_TABLE_QUERY);
             ResultSet resultSet = checkTableStatement.executeQuery()) {

            // Create the "sample_products" table if it doesn't exist
            createTableStatement.executeUpdate();

            // Check if the "sample_products" table exists
            if (!resultSet.next()) {
                // Table doesn't exist, insert sample data
                try (PreparedStatement insertDataStatement = connection.prepareStatement(INSERT_SAMPLE_DATA_QUERY)) {
                    insertDataStatement.executeUpdate();
                }
                System.out.println("Sample data inserted into the 'products' table.");
            } else {
                System.out.println("Table 'products' already exists.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    

    }

    private void updateSampleData() {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement updateStatement = connection.prepareStatement(UPDATE_SAMPLE_DATA_QUERY)) {
            updateStatement.executeUpdate();
            System.out.println("Sample data updated in the 'products' table.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } 
  
    
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement selectAllStatement = connection.prepareStatement(SELECT_ALL_QUERY);
             ResultSet rs = selectAllStatement.executeQuery()) {
            while (rs.next()) {
                long id = rs.getLong("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String image_url = rs.getString("image_url");
                products.add(new Product(id, name, price,image_url));
            }

        return products;
        } catch (SQLException e) {
                System.err.println("Error connecting to primary database: " + e.getMessage());
                // Connection to primary database failed, try fallback data source
                return findProductsFromBackupDataSource();
            }
        }
        private List<Product> findProductsFromBackupDataSource() {
            // Implement logic to retrieve products from a backup data source
            // For example, read products from a local file or return default/fallback data
            List<Product> fallbackProducts = new ArrayList<>();
            fallbackProducts.add(new Product(1L, "Fallback Product 1", 9.99,"images/image.jpeg"));
            fallbackProducts.add(new Product(2L, "Fallback Product 2", 19.99, "/images/image.jpeg"));
            return fallbackProducts;
    
        }
    }

 




/* 
@Repository
public class JdbcProductRepository  {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    
    public List<Product> findAll() {
        String sql = "SELECT * FROM product";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Product product = new Product();
            product.setId(rs.getLong("id"));
            product.setName(rs.getString("name"));
            product.setPrice(rs.getDouble("price"));
            return product;
        });
    }
}

*/
