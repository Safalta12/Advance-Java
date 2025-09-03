import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App extends JFrame implements ActionListener {
    // UI Components
    private JTextField number1Field, number2Field, resultField;
    private JComboBox<String> operationBox;
    private JButton calculateButton, clearButton;

    public App() {
        setTitle("Arithmetic Operations Form");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2, 10, 10));

        // Create components
        JLabel label1 = new JLabel("Enter First Number:");
        number1Field = new JTextField();

        JLabel label2 = new JLabel("Enter Second Number:");
        number2Field = new JTextField();

        JLabel operationLabel = new JLabel("Select Operation:");
        String[] operations = {"Add", "Subtract", "Multiply", "Divide"};
        operationBox = new JComboBox<>(operations);

        JLabel resultLabel = new JLabel("Result:");
        resultField = new JTextField();
        resultField.setEditable(false);

        calculateButton = new JButton("Calculate");
        clearButton = new JButton("Clear");

        // Add ActionListener
        calculateButton.addActionListener(this);
        clearButton.addActionListener(e -> clearFields());

        // Add components to frame
        add(label1);         add(number1Field);
        add(label2);         add(number2Field);
        add(operationLabel); add(operationBox);
        add(resultLabel);    add(resultField);
        add(calculateButton); add(clearButton);

        setLocationRelativeTo(null); // Center the window
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(number1Field.getText());
            double num2 = Double.parseDouble(number2Field.getText());
            String operation = (String) operationBox.getSelectedItem();
            double result = 0;

            switch (operation) {
                case "Add":
                    result = num1 + num2;
                    break;
                case "Subtract":
                    result = num1 - num2;
                    break;
                case "Multiply":
                    result = num1 * num2;
                    break;
                case "Divide":
                    if (num2 == 0) {
                        JOptionPane.showMessageDialog(this, "Cannot divide by zero!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    result = num1 / num2;
                    break;
            }

            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers.", "Input Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void clearFields() {
        number1Field.setText("");
        number2Field.setText("");
        resultField.setText("");
        operationBox.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        new App();
    }
}
