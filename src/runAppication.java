import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class runAppication extends JFrame implements KeyListener {

    private int WIDTH = 820, HEIGHT = 640;
    private BackGround backGround = new BackGround();
    private Search search = new Search();
    private JTextField search1 = search.searchBox1();

    public runAppication() {
        this.setTitle("English - Vietnamese Dictionary");
        ImageIcon icon = new ImageIcon("Image/dictionary_icon2.png");
        this.setIconImage(icon.getImage());
        this.setSize(WIDTH, HEIGHT);
        this.setLocation(30, 30);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        backGround.setBounds(0, 0, WIDTH, HEIGHT);
        backGround.setLayout(null);
        this.add(backGround);
        search1.addKeyListener(this);
        this.add(search1);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        runAppication test = new runAppication();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == 10) {
            System.out.println("You typed : " + search1.getText());
        }
    }

}
