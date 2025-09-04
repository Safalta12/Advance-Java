import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame implements ActionListener {
    private JButton circleBtn, squareBtn, triangleBtn;
    private DrawPanel drawPanel;
    private String currentShape = "";

    public App() {
        setTitle("Shapes");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Button Panel
        JPanel buttonPanel = new JPanel();
        circleBtn = new JButton("Circle");
        squareBtn = new JButton("Square");
        triangleBtn = new JButton("Triangle");

        circleBtn.addActionListener(this);
        squareBtn.addActionListener(this);
        triangleBtn.addActionListener(this);

        buttonPanel.add(circleBtn);
        buttonPanel.add(squareBtn);
        buttonPanel.add(triangleBtn);

        add(buttonPanel, BorderLayout.SOUTH);

        // Drawing Panel
        drawPanel = new DrawPanel();
        add(drawPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == circleBtn) {
            currentShape = "Circle";
        } else if (e.getSource() == squareBtn) {
            currentShape = "Square";
        } else if (e.getSource() == triangleBtn) {
            currentShape = "Triangle";
        }
        drawPanel.repaint();
    }

    class DrawPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int w = getWidth();
            int h = getHeight();

            switch (currentShape) {
                case "Circle":
                    g.setColor(Color.RED);
                    g.fillOval(w / 2 - 50, h / 2 - 50, 100, 100);
                    break;
                case "Square":
                    g.setColor(Color.BLUE);
                    g.fillRect(w / 2 - 50, h / 2 - 50, 100, 100);
                    break;
                case "Triangle":
                    g.setColor(Color.GREEN);
                    int[] xPoints = {w / 2, w / 2 - 60, w / 2 + 60};
                    int[] yPoints = {h / 2 - 60, h / 2 + 60, h / 2 + 60};
                    g.fillPolygon(xPoints, yPoints, 3);
                    break;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new App().setVisible(true);
        });
    }
}
