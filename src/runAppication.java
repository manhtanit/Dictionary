import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.SortedMap;

public class runAppication extends JFrame implements KeyListener, MouseListener {

    private int WIDTH = 820, HEIGHT = 660;
    private String target = "";
    private String explain = "";
    private int length=10;
    private SortedMap<String, String> dictionary =  (new Dictionary()).getDictionary();

    private BackGround backGround = new BackGround();
    private Search search = new Search();
    private JTextField searchField = search.searchBox1();
    private JButton searchButton = search.searchButton1();
    private DictionaryCommandline commandlineInput = new DictionaryCommandline();
    private HintWord testHint = new HintWord();
    private JLabel[] hints = new JLabel[10];
    private ExplainArea explainArea = new ExplainArea();
    private JTextArea explainFinal = explainArea.explainArea("");
    private JMenuBar menuBar = (new Menu()).menu();
    JScrollPane scrollPane = explainArea.scrollPaneFromTextArea(explainFinal);
    private ArrayList<String> hintWords = new ArrayList<String>();


    public runAppication() {
        this.basicAppicationSetting();

        backGround.setBounds(0, 0, WIDTH, HEIGHT);
        backGround.setLayout(null);

        for (int i = 0; i < length; i++) {
            hints[i] = testHint.hintWord(20, 130 + 43 * i, "");
        }

        this.add(backGround);
        backGround.add(searchButton);
        backGround.add(searchField);
        for (int i=0; i<length; i++) {
            backGround.add(hints[i]);
        }


        this.add(scrollPane);

        this.setJMenuBar(menuBar);

        this.handleEvent();
        this.setVisible(true);

    }
    public void basicAppicationSetting() {
        this.setTitle("English - Vietnamese Dictionary");
        ImageIcon icon = new ImageIcon("Image/dictionary_icon2.png");
        this.setIconImage(icon.getImage());
        this.setSize(WIDTH, HEIGHT);
        this.setLocation(30, 30);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void handleEvent() {
        searchField.addKeyListener(this);
        searchField.addMouseListener(this);
        searchButton.addMouseListener(this);
        for (int i=0; i<length; i++) {
            hints[i].addMouseListener(this);
        }
        for (int i=0; i<3; i++) {
            menuBar.getMenu(0).getItem(i).addMouseListener(this);
        }
    }

    public void getHintWords() {
        hintWords  = commandlineInput.dictionaryHintFromSearch(target);
        while (hintWords.size()<10) {
                hintWords.add("  ");
        }
        for (int i = 0; i < length; i++) {
            hints[i].setText(hintWords.get(i));
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() != 0) {
            target = searchField.getText();
            this.getHintWords();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if((e.getSource() == searchField) && (searchField.getText().equals("Type your word"))) {
            searchField.setText("");
        }
        if(e.getSource() == searchButton) {
            target = searchField.getText();
            this.getHintWords();
        }


    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        for (int i=0; i<length; i++) {
            if (e.getSource() == hints[i] && !hints[i].getText().equals("  ")) {
                explain = dictionary.get(hints[i].getText());
                explainFinal.setText(explain);
                searchField.setText(hints[i].getText());
            }
        }
        if (e.getSource() == menuBar.getMenu(0).getItem(2)) {
            System.out.println("Replace");
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        for (int i=0; i<length; i++) {
            if (e.getSource() == hints[i] && !hints[i].getText().equals("  ")) {
                hints[i].setBackground(new Color(66, 160, 54));
            }
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        for (int i=0; i<length; i++) {
            if (e.getSource() == hints[i] && !hints[i].getText().equals("  ")) {
                hints[i].setBackground(new Color(243,220,150));
            }
        }
    }

    public static void main(String[] args) {
        runAppication testApp = new runAppication();
    }


}
