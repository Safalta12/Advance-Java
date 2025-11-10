import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class App extends JFrame implements ItemListener {
         private JRadioButton redButton, greenButton, blueButton;
         private ButtonGroup colorGroup;
         public App() {
         setTitle("Color Selector");
         setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        redButton = new JRadioButton("Red");
       greenButton = new JRadioButton("Green");
       blueButton = new JRadioButton("Blue");      
       colorGroup = new ButtonGroup();
       colorGroup.add(redButton);
       colorGroup.add(greenButton);
        colorGroup.add(blueButton);
add(redButton);
add(greenButton);
add(blueButton);
redButton.addItemListener(this);
greenButton.addItemListener(this);
blueButton.addItemListener(this);
}
    @Override
    public void itemStateChanged(ItemEvent e) {
        Object source = e.getItemSelectable();
        if (source == redButton) {
            getContentPane().setBackground(Color.RED);
        } else if (source == greenButton) {
            getContentPane().setBackground(Color.GREEN);
        } else if (source == blueButton) {
            getContentPane().setBackground(Color.BLUE);
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new App().setVisible(true);
        });
    }
}