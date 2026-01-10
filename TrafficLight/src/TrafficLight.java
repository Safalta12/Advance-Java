import javax.swing.*;
import java.awt.*;

public class TrafficLight extends JFrame implements Runnable {

    private Color red = Color.DARK_GRAY;
    private Color yellow = Color.DARK_GRAY;
    private Color green = Color.DARK_GRAY;

    public TrafficLight() {
        setTitle("Traffic Light");
        setSize(200, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        Thread t = new Thread(this);
        t.start();
    }

    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Color.BLACK);
        g.fillRect(60, 60, 80, 240);

        g.setColor(red);
        g.fillOval(70, 70, 60, 60);

        g.setColor(yellow);
        g.fillOval(70, 150, 60, 60);

        g.setColor(green);
        g.fillOval(70, 230, 60, 60);
    }

    @Override
    public void run() {
        try {
            while (true) {
                red = Color.RED;
                yellow = Color.DARK_GRAY;
                green = Color.DARK_GRAY;
                repaint();
                Thread.sleep(5000);

                red = Color.DARK_GRAY;
                yellow = Color.YELLOW;
                green = Color.DARK_GRAY;
                repaint();
                Thread.sleep(2000);

                red = Color.DARK_GRAY;
                yellow = Color.DARK_GRAY;
                green = Color.GREEN;
                repaint();
                Thread.sleep(10000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new TrafficLight();
    }
}
