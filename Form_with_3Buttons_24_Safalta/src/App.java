import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame {

    public App() {
        setTitle("Color Button Form");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame
        
        // Create buttons
        JButton redButton = new JButton("RED");
        JButton blueButton = new JButton("BLUE");
        JButton greenButton = new JButton("GREEN");

        // Set layout
        setLayout(new FlowLayout());

        // Add buttons to the frame
        add(redButton);
        add(blueButton);
        add(greenButton);

        // ActionListener for all buttons
        ActionListener colorChangeListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton sourceButton = (JButton) e.getSource();
                String caption = sourceButton.getText();

                switch (caption) {
                    case "RED":
                        sourceButton.setBackground(Color.RED);
                        break;
                    case "BLUE":
                        sourceButton.setBackground(Color.BLUE);
                        break;
                    case "GREEN":
                        sourceButton.setBackground(Color.GREEN);
                        break;
                }
                sourceButton.setOpaque(true);  // Important for some Look & Feels
                sourceButton.setBorderPainted(false);  // Optional for cleaner look
            }
        };

        // Register the same listener for all buttons
        redButton.addActionListener(colorChangeListener);
        blueButton.addActionListener(colorChangeListener);
        greenButton.addActionListener(colorChangeListener);
    }

    public static void main(String[] args) {
        // Run GUI in Event Dispatch Thread for thread safety
        SwingUtilities.invokeLater(() -> {
            App form = new App();
            form.setVisible(true);
        });
    }
}
