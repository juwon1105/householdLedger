
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection connect() {
        String url = "jdbc:mysql://localhost:3306/HouseholdDB"; // 데이터베이스 URL
        String user = "root"; // MySQL 사용자명
        String password = "12341234"; // MySQL 비밀번호

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Database connected successfully!");
            return connection;
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
            return null;
        }
    }
}
