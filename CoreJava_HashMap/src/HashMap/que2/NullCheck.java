package HashMap.que2;

import java.util.HashMap;
import java.util.Map;

/***
 What happens when you insert a null key or null value in a HashMap?
 Problem: Add multiple null values and one null key, analyze how they are stored and retrieved.
 */
public class NullCheck {
    public static void main(String[] args) {
        Map<String , String>map=new HashMap<>();

        map.put("A",null);
        map.put("B",null);
        map.put("C",null);
        map.put("D",null);

        map.put(null,"F");
        map.put(null,"G");


        for (Map.Entry<String ,String>maps: map.entrySet()){
            System.out.println("Key "+maps.getKey()+" value "+ map.entrySet());


        }
        System.out.println("value for null key "+map.get(null));
        System.out.println("Contains null key "+map.containsKey(null));
        System.out.println("Contains null value");
    }
}
