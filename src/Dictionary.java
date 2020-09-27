import java.io.InputStream;
import java.util.*;
import java.lang.String;


public class Dictionary {
    public SortedMap<String, String> dic = new TreeMap<>();

    public SortedMap<String, String> getDictionary() {
        this.insertFromFile();
        return new TreeMap<String, String>(dic);
    }

    public void insertFromFile() {

        try {
            InputStream stream = Dictionary.class.getResourceAsStream("/dicfile.jar");
            if (stream == null) {
                System.out.println("Resource not located.");
            }
            //File myObj = new File("dicfile.jar");
            Scanner scanner = new Scanner(stream,"utf-8");
            if (stream != null) {
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
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
