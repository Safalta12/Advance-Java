import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Appextends extends Canvas implements ActionListener {

    private String shape = "";   // which shape to draw
    private JFrame f;

    public Appextends() {
        f = new JFrame("Shape Drawer");
        f.setSize(400, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new BorderLayout());

        // Create buttons
        JButton circleBtn = new JButton("Circle");
        JButton rectBtn = new JButton("Rectangle");
        JButton squareBtn = new JButton("Square");

        // Add action listeners
        circleBtn.addActionListener(this);
        rectBtn.addActionListener(this);
        squareBtn.addActionListener(this);

        // Panel to hold buttons
        JPanel panel = new JPanel();
        panel.add(circleBtn);
        panel.add(rectBtn);
        panel.add(squareBtn);

        f.add(panel, BorderLayout.NORTH);

        // Add canvas (this) to center
        f.add(this, BorderLayout.CENTER);

        f.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        if (shape.equals("Circle")) {
            g.setColor(Color.YELLOW);
            g.fillOval(100, 80, 150, 150);
            g.setColor(Color.RED);
            g.drawOval(100, 80, 150, 150);
        } 
        else if (shape.equals("Rectangle")) {
            g.setColor(Color.CYAN);
            g.fillRect(80, 100, 200, 120);
            g.setColor(Color.BLUE);
            g.drawRect(80, 100, 200, 120);
        } 
        else if (shape.equals("Square")) {
            g.setColor(Color.PINK);
            g.fillRect(100, 80, 150, 150);
            g.setColor(Color.MAGENTA);
            g.drawRect(100, 80, 150, 150);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        shape = e.getActionCommand(); // Circle / Rectangle / Square
        repaint(); // redraw with new shape
    }

    public static void main(String[] args) {
        new Appextends(); // create object to launch GUI
    }
}
