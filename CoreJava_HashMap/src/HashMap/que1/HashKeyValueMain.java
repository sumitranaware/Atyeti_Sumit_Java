package HashMap.que1;

import java.util.HashMap;
import java.util.Map;

/***
 How does HashMap store key-value pairs internally?
 */
public class HashKeyValueMain {
    public static void main(String[] args) {
        Map<HashMapKeyValue, String> map = new HashMap<>();
        map.put(new HashMapKeyValue("one"), "1");
        map.put(new HashMapKeyValue("Two"), "2");
        map.put(new HashMapKeyValue("Three"), "3");

        for (Map.Entry<HashMapKeyValue, String> hash : map.entrySet()) {
            System.out.println(hash.getKey()+" "+hash.getValue());
        }
    }
}