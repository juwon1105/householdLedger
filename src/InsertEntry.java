
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertEntry {
    public static void insertData(String date, String description, double amount) {
        String query = "INSERT INTO entries (date, description, amount) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, date);
            preparedStatement.setString(2, description);
            preparedStatement.setDouble(3, amount);

            int rows = preparedStatement.executeUpdate();
            System.out.println(rows + " row(s) inserted.");
        } catch (SQLException e) {
            System.out.println("Error inserting data: " + e.getMessage());
        }
    }
}
