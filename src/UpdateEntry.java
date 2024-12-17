import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateEntry {
    public static void updateData(int id, String newDate, String newDescription, double newAmount) {
        String query = "UPDATE entries SET date = ?, description = ?, amount = ? WHERE id = ?";

        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, newDate);
            preparedStatement.setString(2, newDescription);
            preparedStatement.setDouble(3, newAmount);
            preparedStatement.setInt(4, id);

            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                System.out.println("Entry updated successfully.");
            } else {
                System.out.println("No entry found with the given ID.");
            }
        } catch (SQLException e) {
            System.out.println("Error updating data: " + e.getMessage());
        }
    }
}
