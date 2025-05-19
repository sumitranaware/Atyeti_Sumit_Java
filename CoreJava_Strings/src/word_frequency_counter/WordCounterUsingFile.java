package word_frequency_counter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.asList;

public class WordCounterUsingFile {
    public static void main(String[] args) {
        try{
            BufferedReader br=new BufferedReader(new FileReader("C:\\Users\\SumitRanaware\\OneDrive - Atyeti Inc\\Desktop\\Atyeti_Sumit_Java\\CoreJava_Strings\\src\\word_frequency_counter\\Paragraph.txt"));
            Map<String , Integer>freqcounter=new HashMap<>();
           String line;
           while (br.ready()){
               line= br.readLine().toLowerCase();
               String[]words=line.split(" ");
               for(String word:words){
                   if(!word.isEmpty()){
                       freqcounter.put(word,freqcounter.getOrDefault(word,0)+1);
                   }

               }
               for(Map.Entry<String,Integer>entry:freqcounter.entrySet()){
                   System.out.println(entry.getKey()+" "+entry.getValue());
               }


           }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
