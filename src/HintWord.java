import javax.swing.*;
import java.awt.*;

public class HintWord {

    public JLabel hintWord(int x, int y, String text)  {
        JLabel hint = new JLabel();
        hint.setText("  " + text);
        hint.setBounds(x, y, 220, 40);
        hint.setFont(new Font("Bookman Old Style",Font.BOLD,16));
        hint.setBackground(new Color(243,220,150));
        hint.setForeground(Color.black);
        hint.setIcon(null);
        hint.setOpaque(true);
        return hint;
    }
}
