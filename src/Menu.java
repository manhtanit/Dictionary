import javax.swing.*;
import java.awt.*;
import java.util.SortedMap;

public class Menu {
    private SortedMap<String, String> dictionary;
    public Menu(SortedMap<String, String> a) {
        dictionary = a;
    }
    public JMenuBar menu() {
        JMenuBar menuBar = new JMenuBar();
        //menuBar.add(Box.createHorizontalGlue());

        JMenu edit = new JMenu();
        JMenuItem add = new JMenuItem("Add");
        JMenuItem remove = new JMenuItem("Remove");
        JMenuItem replace = new JMenuItem("Replace");
        menuBar.setBackground(Color.white);
        menuBar.setBorder(null);
        menuBar.setBounds(0,0,820,40);
        menuBar.setFont(new Font("Bookman Old Style",Font.BOLD,18));

        ImageIcon icon = new ImageIcon(((new ImageIcon("Image/edit_icon2.png")).getImage())
                .getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
        edit.setIcon(icon);
        icon = new ImageIcon(((new ImageIcon("Image/add_icon2.png")).getImage())
                .getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
        menuBar.setAlignmentY(Component.RIGHT_ALIGNMENT);
        add.setIcon(icon);
        icon = new ImageIcon(((new ImageIcon("Image/remove_icon2.png")).getImage())
                .getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
        remove.setIcon(icon);
        icon = new ImageIcon(((new ImageIcon("Image/replace_icon2.png")).getImage())
                .getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
        replace.setIcon(icon);

        icon = new ImageIcon(((new ImageIcon("Image/search_history_icon2.png")).getImage())
                .getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
        JMenuItem history = new JMenuItem("Search History");
        history.setIcon(icon);

        menuBar.add(edit);
        edit.add(add);
        edit.add(remove);
        edit.add(replace);
        edit.add(history);
        return menuBar;
    }

}
