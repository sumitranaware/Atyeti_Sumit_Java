package HashMap.que4;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {
    public static void main(String[] args) {
        LinkedHashMap<Integer,String> linkedHashMap= new LinkedHashMap<>(16,0.75f,true);
        linkedHashMap.put(1,"Apple");
        linkedHashMap.put(2,"Cherry");
        linkedHashMap.put(3,"Date");
        linkedHashMap.put(4,"Orange");

        System.out.println("Before Accessing");
        printMap(linkedHashMap);

        linkedHashMap.get(2);
        linkedHashMap.get(4);

        System.out.println("\n after accessing keys 2 and 4");
        printMap(linkedHashMap);

    }

private static void printMap(LinkedHashMap<Integer,String>map){
        for (Map.Entry<Integer,String>entry:map.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
}



}
