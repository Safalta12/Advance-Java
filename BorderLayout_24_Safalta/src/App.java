import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App extends JFrame implements ActionListener {
    JTextField txtFirst, txtSecond, txtResult;
    JButton btnAdd, btnSub, btnMul, btnDiv;

    public App() {
        setTitle("BorderLayout");
        setSize(500, 300);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // North Panel
        JPanel northPanel = new JPanel();
        JLabel lblTitle = new JLabel("Simple Calculator Application", JLabel.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
        northPanel.add(lblTitle);
        add(northPanel, BorderLayout.NORTH);

        // East Panel
        JPanel eastPanel = new JPanel();
        eastPanel.setLayout(new GridLayout(4, 1, 10, 10));

        btnAdd = new JButton("+", new ImageIcon("add.png"));
        btnSub = new JButton("-", new ImageIcon("subtract.png"));
        btnMul = new JButton("*", new ImageIcon("multiply.png"));
        btnDiv = new JButton("/", new ImageIcon("divide.png"));

        // Align text and icon
        btnAdd.setHorizontalTextPosition(SwingConstants.CENTER);
        btnAdd.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnSub.setHorizontalTextPosition(SwingConstants.CENTER);
        btnSub.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnMul.setHorizontalTextPosition(SwingConstants.CENTER);
        btnMul.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnDiv.setHorizontalTextPosition(SwingConstants.CENTER);
        btnDiv.setVerticalTextPosition(SwingConstants.BOTTOM);

        // Add action listeners
        btnAdd.addActionListener(this);
        btnSub.addActionListener(this);
        btnMul.addActionListener(this);
        btnDiv.addActionListener(this);

        eastPanel.add(btnAdd);
        eastPanel.add(btnSub);
        eastPanel.add(btnMul);
        eastPanel.add(btnDiv);
        add(eastPanel, BorderLayout.EAST);

        // Center Panel
        JPanel centerPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        centerPanel.setBorder(BorderFactory.createTitledBorder("Calculator"));

        centerPanel.add(new JLabel("First Number:"));
        txtFirst = new JTextField(10); // Smaller width
        centerPanel.add(txtFirst);

        centerPanel.add(new JLabel("Second Number:"));
        txtSecond = new JTextField(10); // Smaller width
        centerPanel.add(txtSecond);

        centerPanel.add(new JLabel("Result:"));
        txtResult = new JTextField(10); // Smaller width
        txtResult.setEditable(false);
        centerPanel.add(txtResult);

        add(centerPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(txtFirst.getText());
            double num2 = Double.parseDouble(txtSecond.getText());
            double result = 0;

            if (e.getSource() == btnAdd) {
                result = num1 + num2;
            } else if (e.getSource() == btnSub) {
                result = num1 - num2;
            } else if (e.getSource() == btnMul) {
                result = num1 * num2;
            } else if (e.getSource() == btnDiv) {
                if (num2 == 0) {
                    JOptionPane.showMessageDialog(this, "Cannot divide by zero.");
                    return;
                }
                result = num1 / num2;
            }

            txtResult.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers.");
        }
    }

    public static void main(String[] args) {
        new App();
    }
}
