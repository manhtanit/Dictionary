import javax.swing.*;
import java.awt.*;

public class BackGround extends JPanel{
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics g2D = (Graphics) g;
        /* Right block */
        Color colorPen = new Color(221, 245, 165);
        g2D.setColor(colorPen);
        g2D.fillRect(260, 0, 540, 600);
        /* Left block */
        colorPen = new Color(53,47,87);
        g2D.setColor(colorPen);
        g2D.fillRect(0, 0, 260, 600);
        /* Search Box */
        colorPen = new Color(243,220,150);
        g2D.setColor(colorPen);
        g2D.fillRoundRect(10, 60, 240, 40, 15, 15);
        /* Hint box */
        g2D.fillRoundRect(10, 120, 240, 450, 15, 15);
        /* Eplain box */
        colorPen = new Color(243,220,150);
        g2D.setColor(colorPen);
        g2D.fillRoundRect(270, 120, 520, 450, 15, 15);
        /* Difinition box */
        colorPen = new Color(243,220,150);
        g2D.setColor(colorPen);
        g2D.fillRoundRect(270, 60, 180, 40, 15, 15);
        ImageIcon searchIcon = new ImageIcon("Image/search_icon.png");
        g2D.drawImage(searchIcon.getImage(),220,67,25,25,null);
        colorPen = new Color(53,47,87);
        g2D.setColor(colorPen);
        g2D.setFont(new Font("Bookman Old Style",Font.BOLD,22));
        g2D.drawString("DEFINITION: ",288,88);
    }
}
