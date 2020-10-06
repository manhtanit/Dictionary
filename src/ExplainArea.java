import javax.swing.*;
import java.awt.*;

public class ExplainArea {
    public JTextArea explainArea(String text)  {
        JTextArea explain = new JTextArea();
        explain.setText("" + text);
        explain.setBounds(280, 130, 500, 430);
        explain.setFont(new Font("Arial",Font.ITALIC,16));
        explain.setForeground(Color.black);
        explain.setLineWrap(true);
        explain.setWrapStyleWord(true);
        explain.setEditable(false);
        explain.setOpaque(false);
        explain.setLayout(null);
        return explain;
    }

    public JScrollPane scrollPaneFromTextArea(JTextArea explainFinal) {
        JScrollPane scrollPane = new JScrollPane(explainFinal);
        scrollPane.setPreferredSize(new Dimension(500,420));
        scrollPane.setBounds(280, 130, 500, 430);
        scrollPane.setBorder(null);
        scrollPane.getViewport().setBackground(new Color(243,220,150));
        return scrollPane;
    }
    
}
