import javax.swing.*;
import java.awt.*;

public class Search {
    JTextField searchBox;

    public JTextField searchBox1() {
        searchBox = new JTextField("Type your word");
        searchBox.setLayout(null);
        searchBox.setBounds(15, 64, 200, 34);
        searchBox.setFont(new Font("Bookman Old Style",Font.BOLD,16));
        Color colorPen = new Color(243,220,150);
        searchBox.setBackground(colorPen);
        searchBox.setBorder(null);
        searchBox.setVisible(true);
        return searchBox;
    }

    public JButton searchButton1() {
        JButton button = new JButton(new ImageIcon(((new ImageIcon("Image/search_icon.png"))
                .getImage()).getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)));
        button.setBounds(220, 67, 25, 25);
        button.setBorder(null);
        button.setLayout(null);
        return button;
    }


}
