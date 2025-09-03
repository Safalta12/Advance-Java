import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.event.MouseInputAdapter;

import java.awt.event.MouseEvent;

public class App {
    public static void main(String[] args) throws Exception {
        JFrame f=new JFrame("PopupMenu Example");
        JPopupMenu popupmenu=new JPopupMenu("Edit");
        JMenuItem cut=new JMenuItem("Cut");
        JMenuItem copy=new JMenuItem("Copy");
        JMenuItem paste=new JMenuItem("Paste");
        popupmenu.add(cut);
        popupmenu.add(copy);
        popupmenu.add(paste);
        f.addMouseListener(new MouseInputAdapter() {
            public void mouseClicked(MouseEvent e){
                popupmenu.show(f, e.getX(),e.getY());
            }
        });
        f.add(popupmenu);
        f.setSize(300,300);
        f.setLayout(null);
        f.setVisible(true);
    }
}
