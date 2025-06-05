package HashMap.que3;

import java.util.HashMap;
import java.util.Map;

public class InsertionOrder {
    public static void main(String[] args) {
        Map<String,Integer>map=new HashMap<>();
        map.put("Banana",3);
        map.put("Apple",5);
        map.put("Orange",2);
        map.put("Grapes",4);
        map.put("Mango",1);

        System.out.println("Hashmap Iteration order");
        for (Map.Entry<String ,Integer>entry:map.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }
}
