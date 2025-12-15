import java.awt.event.*;
import javax.swing.*;

public class App {

    JTextField t1;
    JTextField t2;
    JTextField t3;
    JPopupMenu pm;
    JFrame f=new JFrame();
    public App(){
      f.setTitle("Calculator");
      f.setSize(400,250);
      f.setLayout(null);

      JLabel f1=new JLabel("First Digit");
      f1.setBounds(20,20,200,25);
      t1=new JTextField();
      t1.setBounds(200,20,150,25);
      f.add(f1);
      f.add(t1);

      JLabel f2=new JLabel("Second Digit");
       f2.setBounds(20,60,200,25);
      t2=new JTextField();
      t2.setBounds(200,60,150,25);
      f.add(f2);
      f.add(t2);

      JLabel f3=new JLabel("Result");
       f3.setBounds(20,100,200,25);
      t3=new JTextField();
      t3.setBounds(200,100,150,25);
      f.add(f3);
      f.add(t3);

        pm = new JPopupMenu();
        JMenuItem add = new JMenuItem("Add");
        JMenuItem sub = new JMenuItem("Subtract");
        JMenuItem mul = new JMenuItem("Multiply");
        JMenuItem div = new JMenuItem("Divide");

        pm.add(add);
        pm.add(sub);
        pm.add(mul);
        pm.add(div);


        f.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    pm.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });

        add.addActionListener(e -> calculate('+'));
        sub.addActionListener(e -> calculate('-'));
        mul.addActionListener(e -> calculate('*'));
        div.addActionListener(e -> calculate('/'));

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    void calculate(char op) {
        double a = Double.parseDouble(t1.getText());
        double b = Double.parseDouble(t2.getText());
        double r = 0;

        switch (op) {
            case '+': r = a + b; break;
            case '-': r = a - b; break;
            case '*': r = a * b; break;
            case '/': r = a / b; break;
        }
        t3.setText(String.valueOf(r));
    }

    public static void main(String[] args) {
        new App();
    }
}