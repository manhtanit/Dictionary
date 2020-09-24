import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Search {
    private JTextField searchBox;
    private DictionaryCommandline test = new DictionaryCommandline();
    private ArrayList<String> hintWords = new ArrayList<String>();
    public JTextField searchBox1() {
        searchBox = new JTextField("Type your word");
        searchBox.setLayout(null);
        searchBox.setBounds(15, 64, 200, 34);
        searchBox.setFont(new Font("Bookman Old Style",Font.BOLD,14));
        Color colorPen = new Color(243,220,150);
        searchBox.setBackground(colorPen);
        searchBox.setVisible(true);
        return searchBox;
    }
    public JButton searchButton1() {
        JButton searchButton = new JButton("Search");
        ImageIcon icon = new ImageIcon("Image/seach_icon.png");
        searchButton.setIcon(icon);
        searchButton.setBounds(320,67,60,25);
        return searchButton;
    }


}
