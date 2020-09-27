import java.util.Scanner;
import java.util.ArrayList;
import java.util.SortedMap;

public class DictionaryCommandline {

    private DictionaryManagement engDic = new DictionaryManagement();
    public DictionaryCommandline() {
        engDic.insertFromFile();
    }
    public void dictionaryBasic() {
        engDic.insertFromCommandline();
        showAllWorlds();
    }

    public void showAllWorlds() {
        int i = 0;
        for (String c : engDic.dictionary1.dic.keySet()) {
            String temp = Integer.toString(i++);
            while (temp.length() < 6) {
                temp = " " + temp;
            }
            String target = c;
            while (target.length() < 20) {
                target = " " + target;
            }

            System.out.print(temp + target + "    ");
            String temp2 = engDic.dictionary1.dic.get(c);
            temp2 = temp2.replaceAll("\n", "");
            int k = 0;
            int check = 0;
            while (k < temp2.length()) {
                if (k % 50 == check && k != 0) {
                    System.out.print("\n                              ");
                    System.out.print(temp2.charAt(k));
                } else if (temp2.charAt(k) == '-' || temp2.charAt(k) == '*' || temp2.charAt(k) == '=' || temp2.charAt(k) == '!') {
                    System.out.println("");
                    System.out.print("                              ");
                    System.out.print(temp2.charAt(k));
                    check = k % 50;
                } else {
                    System.out.print(temp2.charAt(k));
                }
                k++;
            }
            System.out.println("");

        }
    }

    public void dictionaryAdvanced() {
        engDic.insertFromFile();
        showAllWorlds();
        engDic.dictionaryLookup();
    }

    public void  dictionarySearcher() {
        System.out.println("Type your hint: ");
        String s;
        Scanner findHint = new Scanner(System.in);
        s = findHint.nextLine();
        boolean check = false;
        boolean found = false;
        ArrayList<String> hintWords = new ArrayList<String>();
        for (String c: engDic.dictionary1.dic.keySet()) {
            if (c.startsWith(s)) {
                hintWords.add(c);
                check = true;
                found = true;
            } else {
                check = false;
            }
            if (found&&!check) {
                break;
            }
        }
        System.out.println("What we found : ");
        for (String c: hintWords) {
            System.out.println(c);
        }
    }
    public ArrayList<String>  dictionaryHintFromSearch(String s) {
        boolean check = false;
        boolean found = false;
        ArrayList<String> hintWords = new ArrayList<String>();
        for (String c: engDic.dictionary1.dic.keySet()) {
            if (c.startsWith(s)) {
                hintWords.add(c);
                check = true;
                found = true;
            } else {
                check = false;
            }
            if (found&&!check) {
                break;
            }
        }
        return new ArrayList<String>(hintWords);
    }

}
