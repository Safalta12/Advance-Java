import java.awt.event.*;
import javax.swing.*;

public class App implements ActionListener{
    JTextField firstDigit;
    JTextField secondDigit;
    JButton calculateButton;
    JTextField outputField;
    JFrame f=new JFrame();
    public App(){
        f.setTitle("Two Digit Calculator");
        JLabel firstDigitLabel=new JLabel("First Digit");
        firstDigitLabel.setBounds(20,20,200,25);
        firstDigit=new JTextField();
        firstDigit.setBounds(200,20,150,25);
        f.add(firstDigitLabel);
        f.add(firstDigit);
        JLabel secondDigitLabel=new JLabel("Second Digit");
        secondDigitLabel.setBounds(20,60,200,25);
        secondDigit=new JTextField();
        secondDigit.setBounds(200,60,150,25);
        f.add(secondDigitLabel);
        f.add(secondDigit);
        calculateButton=new JButton("Calculate");
        calculateButton.setBounds(200,100,150,25);
        f.add(calculateButton);
        JLabel outputLabel=new JLabel("Sum:");
        outputLabel.setBounds(20,140,200,25);
        outputField=new JTextField();
        outputField.setBounds(200,140,150,25);
        calculateButton.addActionListener(this);
        f.add(outputLabel);
        f.add(outputField);
        f.setSize(400,300);
        f.setLayout(null);
        f.setVisible(true);
    }
    @Override
     public void actionPerformed(ActionEvent e){
        int number1=Integer.parseInt(firstDigit.getText());
        int number2=Integer.parseInt(secondDigit.getText());
        int sum=number1+number2;
        outputField.setText(String.valueOf(sum));
     }
     
    public static void main(String[] args) throws Exception {
       new App();
    }
}
