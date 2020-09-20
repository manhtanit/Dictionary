import java.util.HashMap;
import java.util.Scanner;
import java.util.*;

public class DictionaryManagement {

    /*public static void main(String[] args) {
        DictionaryManagement dicTest = new DictionaryManagement();
        dicTest.insertFromCommandline();
        dicTest.print();
    }*/

    public SortedMap<String, String> dicWord = new TreeMap<String, String>();

    private int n = 0;

    public void insertFromCommandline() {
        Scanner scannerWord = new Scanner(System.in);
        n = scannerWord.nextInt();
        String rong = scannerWord.nextLine();
        for (int i=0; i < n; i++){
            Word newWord = new Word();
            newWord.word_target = scannerWord.nextLine();
            newWord.word_explain = scannerWord.nextLine();
            dicWord.put(newWord.word_target, newWord.word_explain);
        }
        scannerWord.close();
    }

    public int getSize() {
        return n;
    }
}
