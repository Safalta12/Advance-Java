import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App extends JFrame implements ActionListener {

    // Components for center panel
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JCheckBox rememberMeCheckBox;
    private JButton loginButton;

    // Components for south panel
    private JButton resetButton, exitButton;

    public App() {
        setTitle("Lab-9 Layout Manager Demo");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main frame uses BorderLayout
        setLayout(new BorderLayout());

        // North Panel with FlowLayout - three labels
        JPanel northPanel = new JPanel(new FlowLayout());
        northPanel.add(new JLabel("Name"));
        northPanel.add(new JLabel("Roll No"));
        northPanel.add(new JLabel("Class"));
        add(northPanel, BorderLayout.NORTH);

        // Center Panel with GridLayout (3 rows, 2 columns)
        JPanel centerPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        
        centerPanel.add(new JLabel("Username:"));
        usernameField = new JTextField();
        centerPanel.add(usernameField);

        centerPanel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        centerPanel.add(passwordField);

        rememberMeCheckBox = new JCheckBox("Remember Me");
        centerPanel.add(rememberMeCheckBox);

        loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        centerPanel.add(loginButton);

        add(centerPanel, BorderLayout.CENTER);

        // South Panel with FlowLayout - two buttons
        JPanel southPanel = new JPanel(new FlowLayout());
        resetButton = new JButton("Reset");
        resetButton.addActionListener(this);
        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);

        southPanel.add(resetButton);
        southPanel.add(exitButton);

        add(southPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loginButton) {
            String username = usernameField.getText();
            JOptionPane.showMessageDialog(this, "Logged in as: " + username);
        } else if(e.getSource() == resetButton) {
            usernameField.setText("");
            passwordField.setText("");
            rememberMeCheckBox.setSelected(false);
        } else if(e.getSource() == exitButton) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new App().setVisible(true);
        });
    }
}
