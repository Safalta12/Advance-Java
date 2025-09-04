import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame implements ActionListener {

    private JLabel userLabel, passLabel;
    private JTextField userText;
    private JPasswordField passText;
    private JButton loginButton;

    public App() {
        setTitle("Login Form");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center on screen

        // Set layout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Username Label
        userLabel = new JLabel("Username:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 5, 10); // Top, Left, Bottom, Right
        add(userLabel, gbc);

        // Username Text Field
        userText = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(userText, gbc);

        // Password Label
        passLabel = new JLabel("Password:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(5, 10, 5, 10);
        add(passLabel, gbc);

        // Password Field
        passText = new JPasswordField(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(passText, gbc);

        // Login Button
        loginButton = new JButton("Login");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(loginButton, gbc);

        loginButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = userText.getText();
        String password = new String(passText.getPassword());

        if (username.equals("admin") && password.equals("password")) {
            JOptionPane.showMessageDialog(this, "Login Successful!");
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Credentials!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new App().setVisible(true);
        });
    }
}
