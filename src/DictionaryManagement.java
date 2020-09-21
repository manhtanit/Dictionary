import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;

public class DictionaryManagement {
    Dictionary dictionary1 = new Dictionary();

    private int n = 0;

    public void insertFromCommandline() {
        Scanner scannerWord = new Scanner(System.in);
        n = scannerWord.nextInt();
        String rong = scannerWord.nextLine();
        for (int i=0; i < n; i++){
            Word newWord = new Word();
            newWord.word_target = scannerWord.nextLine();
            newWord.word_explain = scannerWord.nextLine();
            dictionary1.dic.put(newWord.word_target, newWord.word_explain);
        }
        scannerWord.close();
    }

    public int getSize() {
        return n;
    }

    public void insertFromFile() {
        try {
            File myObj = new File("dicfile.txt");
            Scanner scanner = new Scanner(myObj);
            if (myObj.exists()) {
                String key = "";
                String value = "";
                int i = 0;
                while (scanner.hasNextLine()) {
                    String data = scanner.nextLine();
                    if (data.startsWith("@")) {
                        dictionary1.dic.put(key, value);
                        value = "";
                        if (data.contains("/")) {
                            char[] temp = data.toCharArray();
                            int index = data.indexOf("/");
                            key = String.copyValueOf(temp, 1, index - 2);
                            String temp2 = String.copyValueOf(temp, index, data.length() - index);
                            value = value + temp2 + "\n";
                        } else {
                            char[] temp = data.toCharArray();
                            key = String.copyValueOf(temp, 1, data.length()-1);
                        }
                    } else {
                        value = value + data + "\n";
                    }

                }
            } else {
                System.out.println("Cannot open file!");
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void dictionaryLookup() {
        String s;
        Scanner findWord = new Scanner(System.in);
        System.out.println("Press Your Word: ");
        s = findWord.nextLine();
        if (dictionary1.dic.containsKey(s)) {
            System.out.println("Explain of " + s.toUpperCase() + " : \n" + dictionary1.dic.get(s));
        } else {
            System.out.println("Cannot find!");
        }
    }

}
