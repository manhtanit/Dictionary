import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

public class DictionaryManagement {

    Dictionary dictionary1 = new Dictionary();

    private int n = 0;

    public void insertFromCommandline() {

        Scanner scannerWord = new Scanner(System.in);
        n = scannerWord.nextInt();
        String rong = scannerWord.nextLine();
        for (int i = 0; i < n; i++) {
            Word newWord = new Word();
            newWord.word_target = scannerWord.nextLine();
            newWord.word_explain = scannerWord.nextLine();
            dictionary1.dic.put(newWord.word_target, newWord.word_explain);
        }
        scannerWord.close();
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
                            key = String.copyValueOf(temp, 1, data.length() - 1);
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
        System.out.println("Type Your Word: ");
        s = findWord.nextLine();
        if (dictionary1.dic.containsKey(s)) {
            System.out.println("Explain of " + s.toUpperCase() + " : \n" + dictionary1.dic.get(s));
        } else {
            System.out.println("Cannot find!");
        }
        findWord.close();
    }

    public void addWord(Word word) {

        dictionary1.dic.put(word.word_target,word.word_explain);
    }
    public void removeWord(Word word) {

        if (dictionary1.dic.containsKey(word.word_target)) {
            dictionary1.dic.remove(word.word_target);
        }
    }
    public void replaceWord(Word word) {

        if (dictionary1.dic.containsKey(word.word_target)) {
            dictionary1.dic.replace(word.word_target, word.word_explain);
        }
    }

    public void  dictionaryExportToFile(){

        try {
            PrintWriter fileOut = new PrintWriter("DicExprot.txt");
            int i = 0;
            for (String c : dictionary1.dic.keySet()) {
                String temp = Integer.toString(i++);
                while (temp.length() < 6) {
                    temp = " " + temp;
                }
                String target = c;
                while (target.length() < 20) {
                    target = " " + target;
                }

                fileOut.print(temp + target + "    ");
                String temp2 = dictionary1.dic.get(c);
                temp2 = temp2.replaceAll("\n", "");
                int k = 0;
                int check = 0;
                while (k < temp2.length()) {
                    if (k % 50 == check && k != 0) {
                        fileOut.print("\n                              ");
                        fileOut.print(temp2.charAt(k));
                    } else if (temp2.charAt(k) == '-' || temp2.charAt(k) == '*' || temp2.charAt(k) == '=' || temp2.charAt(k) == '!') {
                        fileOut.println("");
                        fileOut.print("                              ");
                        fileOut.print(temp2.charAt(k));
                        check = k % 50;
                    } else {
                        fileOut.print(temp2.charAt(k));
                    }
                    k++;
                }
                fileOut.println("");

            }
            fileOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
