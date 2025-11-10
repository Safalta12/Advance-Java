import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class App extends JFrame implements ActionListener {
    private JButton newButton, loginButton, logoutButton;
    public App() {
        setTitle("Toolbar with three buttons");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JToolBar toolBar = new JToolBar();
        newButton = new JButton("New");
        loginButton = new JButton("Login");
        logoutButton = new JButton("Logout");
        toolBar.add(newButton);
        toolBar.add(loginButton);
        toolBar.add(logoutButton);
        newButton.addActionListener(this);
        loginButton.addActionListener(this);
        logoutButton.addActionListener(this);
        add(toolBar, BorderLayout.NORTH);
        getContentPane().setBackground(Color.WHITE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == newButton) {
            JOptionPane.showMessageDialog(this, "New File Created");
        } else if (source == loginButton) {
            JOptionPane.showMessageDialog(this, "Login Successful");
        } else if (source == logoutButton) {
            JOptionPane.showMessageDialog(this, "Logged Out");
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new App().setVisible(true);
        });
    }
}
