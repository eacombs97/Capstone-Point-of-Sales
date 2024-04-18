import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DatabaseManager {
    private static final String URL = "jdbc:database.bitbuggy.dev://localhost:3306/bitbuggy";
    private static final String USERNAME = "pos";
    private static final String PASSWORD = "BitBuggy!!2024?Wh3r3sMyDBA?";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
