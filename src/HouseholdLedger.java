import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HouseholdLedger {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Household Ledger");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel dateLabel = new JLabel("Date (YYYY-MM-DD):");
        dateLabel.setBounds(10, 20, 150, 25);
        panel.add(dateLabel);

        JTextField dateField = new JTextField(20);
        dateField.setBounds(180, 20, 200, 25);
        panel.add(dateField);

        JLabel descLabel = new JLabel("Description:");
        descLabel.setBounds(10, 50, 150, 25);
        panel.add(descLabel);

        JTextField descField = new JTextField(20);
        descField.setBounds(180, 50, 200, 25);
        panel.add(descField);

        JLabel amountLabel = new JLabel("Amount:");
        amountLabel.setBounds(10, 80, 150, 25);
        panel.add(amountLabel);

        JTextField amountField = new JTextField(20);
        amountField.setBounds(180, 80, 200, 25);
        panel.add(amountField);

        JButton addButton = new JButton("Add Entry");
        addButton.setBounds(10, 120, 150, 25);
        panel.add(addButton);

        JButton viewButton = new JButton("View Entries");
        viewButton.setBounds(180, 120, 150, 25);
        panel.add(viewButton);

        JButton deleteButton = new JButton("Delete Entry");
        deleteButton.setBounds(10, 160, 150, 25);
        panel.add(deleteButton);

        JButton updateButton = new JButton("Update Entry");
        updateButton.setBounds(180, 160, 150, 25);
        panel.add(updateButton);

        // Add Entry 버튼 이벤트
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String date = dateField.getText();
                String description = descField.getText();
                double amount;

                try {
                    amount = Double.parseDouble(amountField.getText());
                    InsertEntry.insertData(date, description, amount);
                    JOptionPane.showMessageDialog(null, "Entry Added!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid amount.");
                }
            }
        });

        // View Entries 버튼 이벤트
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewEntries.viewData();
            }
        });

        // Delete Entry 버튼 이벤트
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idInput = JOptionPane.showInputDialog("Enter the ID of the entry to delete:");
                try {
                    int id = Integer.parseInt(idInput);
                    DeleteEntry.deleteData(id);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid ID.");
                }
            }
        });

        // Update Entry 버튼 이벤트
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idInput = JOptionPane.showInputDialog("Enter the ID of the entry to update:");
                try {
                    int id = Integer.parseInt(idInput);

                    String newDate = JOptionPane.showInputDialog("Enter new date (YYYY-MM-DD):");
                    String newDescription = JOptionPane.showInputDialog("Enter new description:");
                    String newAmountInput = JOptionPane.showInputDialog("Enter new amount:");

                    try {
                        double newAmount = Double.parseDouble(newAmountInput);
                        UpdateEntry.updateData(id, newDate, newDescription, newAmount);
                        JOptionPane.showMessageDialog(null, "Entry Updated!");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid amount.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid ID.");
                }
            }
        });
    }
}