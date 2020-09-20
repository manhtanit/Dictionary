import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.*;
import java.lang.String;


public class Dictionary {
    SortedMap<String, String> dic = new TreeMap<String, String>();
    public void loadDictionary() {
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
                        dic.put(key, value);
                        value = "";
                        if (data.contains("/")) {
                            char[] temp = data.toCharArray();
                            int index = data.indexOf("/");
                            key = String.copyValueOf(temp, 1, index - 1);
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
        DictionaryManagement dicMag = new DictionaryManagement();
        dicMag.insertFromCommandline();
        for (String c : dicMag.dicWord.keySet()) {
            dic.put(c, dicMag.dicWord.get(c));
        }
    }

}
