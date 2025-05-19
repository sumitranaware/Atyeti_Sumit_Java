package word_frequency_counter;

import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.asList;

public class WordCounter {
    public static void main(String[] args) {
        String para="This is a String problem that counts the number of string in a paragraph";

        Map<String , Integer>counter =new HashMap<>();
       String lowercase= para.toLowerCase();
        asList(lowercase.split(" ")).forEach(s->{
            if (counter.containsKey(s)){
                Integer count=counter.get(s);
                counter.put(s,count+1);

            }else {
                counter.put(s,1);
            }
        });
        System.out.println(counter.toString());
    }
}
