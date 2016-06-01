package wordcount;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
  
  public static void main(String[] args) throws IOException {
    String line;
    File file = new File(args[0]);
    FileReader fr = new FileReader(file);
    Map counts = new HashMap();
    BufferedReader br = new BufferedReader(fr);
    while ((line = br.readLine()) != null) {
      String[] words = line.split(" ");
      for (int i = 0; i < words.length; i++) {
        String word = words[i];
        Integer count = (Integer)counts.get(word);
        if (count == null) {
          counts.put(word, 1);
        } else {
          counts.put(word, new Integer(count.intValue() + 1));
        }
      }
    }
    System.out.println(counts);
  }

}
