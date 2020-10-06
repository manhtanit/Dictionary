import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.SortedMap;
import java.util.TreeMap;

public class Editing {

    SortedMap<String, String> dictionary =  new TreeMap<String, String>();

    public Editing(SortedMap<String, String> d) {
        dictionary = d;
    }

    public void handleEvent(int i) {
        switch (i) {
            case 0:
                Add add = new Add();
                break;

            case 1:
                Remove remove = new Remove();
                break;

            case 2:
                Replace replace = new Replace();
                break;

            default:
                History history = new History();
                break;
        }
    }

    class Add extends JFrame implements ActionListener {
        JFrame frame = new JFrame();
        JTextField targetTextField = new JTextField();
        JLabel targetLabel = new JLabel();
        JTextField meaningTextField = new JTextField();
        JLabel meaningLabel = new JLabel();
        JButton addButton;
        Word t = new Word();

        public Add() {
            frame.setTitle("Add");
            frame.setBounds(500,300,400,220);
            frame.setLayout(null);
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frame.setIconImage(new ImageIcon(((new ImageIcon("Image/add_icon2.png")).getImage())
                    .getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH)).getImage());
            frame.setBackground(new Color(243,220,150));

            targetLabel.setText("Target: ");
            targetLabel.setBounds(40,20,60,40);
            targetTextField.setBounds(120,20,200,40);
            meaningLabel.setText("Meaning: ");
            meaningLabel.setBounds(40,80,60,40);
            meaningTextField.setBounds(120,80,200,40);
            addButton = new JButton("Add");
            addButton.setBounds(170,130,80,35);
            addButton.addActionListener(this);
            frame.add(addButton);
            frame.add(targetLabel);
            frame.add(targetTextField);
            frame.add(meaningLabel);
            frame.add(meaningTextField);

            frame.setVisible(true);
        }

        public Word getWord() {
            return t;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == addButton) {
                runAppication.dictionary.put(targetTextField.getText(),meaningTextField.getText());
            }
        }
    }

    class Replace extends JFrame implements ActionListener {
        JFrame frame = new JFrame();
        JTextField targetTextField = new JTextField();
        JLabel targetLabel = new JLabel();
        JTextField meaningTextField = new JTextField();
        JLabel meaningLabel = new JLabel();
        JButton addButton;

        public Replace() {
            frame.setTitle("Replace");
            frame.setBounds(500,300,400,220);
            frame.setLayout(null);
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frame.setIconImage(new ImageIcon(((new ImageIcon("Image/replace_icon2.png")).getImage())
                    .getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH)).getImage());
            frame.setBackground(new Color(243,220,150));

            targetLabel.setText("Target: ");
            targetLabel.setBounds(40,20,60,40);
            targetTextField.setBounds(120,20,200,40);
            meaningLabel.setText("Meaning: ");
            meaningLabel.setBounds(40,80,60,40);
            meaningTextField.setBounds(120,80,200,40);
            addButton = new JButton("Replace");
            addButton.setBounds(170,130,80,35);
            addButton.addActionListener(this);
            frame.add(addButton);
            frame.add(targetLabel);
            frame.add(targetTextField);
            frame.add(meaningLabel);
            frame.add(meaningTextField);

            frame.setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == addButton) {
                if (runAppication.dictionary.containsKey(targetTextField.getText())) {
                    runAppication.dictionary.replace(targetTextField.getText(),meaningTextField.getText());
                }
            }
        }
    }

    class Remove extends JFrame implements ActionListener {
        JFrame frame = new JFrame();
        JTextField targetTextField = new JTextField();
        JLabel targetLabel = new JLabel();
        JButton addButton;

        public Remove() {
            frame.setTitle("Remove");
            frame.setBounds(500,300,400,220);
            frame.setLayout(null);
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frame.setIconImage(new ImageIcon(((new ImageIcon("Image/remove_icon2.png")).getImage())
                    .getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH)).getImage());
            frame.setBackground(new Color(243,220,150));

            targetLabel.setText("Target: ");
            targetLabel.setBounds(40,50,60,40);
            targetTextField.setBounds(120,50,200,40);
            addButton = new JButton("Remove");
            addButton.setBounds(170,130,80,35);
            addButton.addActionListener(this);
            frame.add(addButton);
            frame.add(targetLabel);
            frame.add(targetTextField);
            frame.setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == addButton) {
                if (runAppication.dictionary.containsKey(targetTextField.getText())) {
                    runAppication.dictionary.remove(targetTextField.getText());
                }
            }
        }
    }

    class History extends JFrame implements MouseListener {

        JFrame frame = new JFrame();
        JTextArea history = new JTextArea(runAppication.historySearch);
        JScrollPane scrollPane;
        final int HEIGHT = 640;
        final int WIDTH = 600;

        public History() {
            frame.setTitle("History");
            frame.setBounds(500,300,WIDTH,HEIGHT);
            frame.setLayout(null);
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frame.setIconImage(new ImageIcon(((new ImageIcon("Image/search_history_icon2.png")).getImage())
                    .getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH)).getImage());

            JTextArea explain = new JTextArea();

            history.setBounds(20, 20, WIDTH - 40, HEIGHT - 40);
            history.setFont(new Font("Arial",Font.ITALIC,16));
            history.setForeground(Color.black);
            history.setLineWrap(true);
            history.setWrapStyleWord(true);
            history.setEditable(false);
            history.setOpaque(false);
            history.setLayout(null);

            scrollPane = new JScrollPane(history);
            scrollPane.setBounds(20, 20, WIDTH - 60, HEIGHT - 90);
            scrollPane.setBorder(null);
            scrollPane.getViewport().setBackground(new Color(243,220,150));

            frame.add(scrollPane);

            frame.setVisible(true);
        }


        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}

