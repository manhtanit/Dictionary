import javax.swing.*;
import java.awt.*;

public class Menu {
    public JMenuBar menu() {
        JMenuBar menuBar = new JMenuBar();
        //menuBar.add(Box.createHorizontalGlue());

        JMenu edit = new JMenu();
        JMenuItem add = new JMenuItem("Add");
        JMenuItem remove = new JMenuItem("Remove");
        JMenuItem replace = new JMenuItem("Replace");
        menuBar.add(edit);
        menuBar.setBackground(Color.white);
        menuBar.setBorder(null);
        menuBar.setBorderPainted(false);
        menuBar.setBounds(0,0,820,40);
        menuBar.setFont(new Font("Bookman Old Style",Font.BOLD,18));
        edit.setIcon(new ImageIcon(((new ImageIcon("Image/edit_icon.png")).getImage())
                .getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH)));
        menuBar.setAlignmentY(Component.RIGHT_ALIGNMENT);
        JMenu help = new JMenu("Help");
        menuBar.add(help);
        edit.add(add);
        edit.add(remove);
        edit.add(replace);
        edit.getItem(0).setText("Test");
        return menuBar;
    }
}
