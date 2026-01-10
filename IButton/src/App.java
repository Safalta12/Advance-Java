import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class App extends JFrame {

    JLabel imageLabel;
    JButton browseButton;

    public App() {
   
        setTitle("Image Upload ");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        imageLabel = new JLabel("No Image Selected", JLabel.CENTER);
        add(imageLabel, BorderLayout.CENTER);

 
        browseButton = new JButton("Browse");
        add(browseButton, BorderLayout.SOUTH);

 
        browseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();

         
                fileChooser.setAcceptAllFileFilterUsed(false);
                fileChooser.addChoosableFileFilter(
                        new javax.swing.filechooser.FileNameExtensionFilter(
                                "Image Files", "jpg", "png", "jpeg"));

                int result = fileChooser.showOpenDialog(null);

                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();

                    ImageIcon imageIcon = new ImageIcon(selectedFile.getAbsolutePath());
                    Image image = imageIcon.getImage().getScaledInstance(
                            imageLabel.getWidth(),
                            imageLabel.getHeight(),
                            Image.SCALE_SMOOTH);

                    imageLabel.setIcon(new ImageIcon(image));
                    imageLabel.setText(null);
                }
            }
        });
    }

    public static void main(String[] args) {
        new App().setVisible(true);
    }
}
