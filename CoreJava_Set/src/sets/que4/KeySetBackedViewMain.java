package sets.que4;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/***
 6. Set backed by Map keySet view – side effects
 Map.keySet() is a backed view. Removing from set affects the map.
 Problem:
 Create a Map, get its keySet, remove from set and observe how map changes.
 */
public class KeySetBackedViewMain {
    public static void main(String[] args) {
        Map<String ,Integer>marks=new HashMap<>();
        marks.put("Sumit",90);
        marks.put("Shubham",89);
        marks.put("Rohit",88);
        System.out.println("Original Map: "+marks);

        Set<String>keys=marks.keySet();
        keys.remove("Shubham");

        System.out.println("Modified keySet "+keys);
        System.out.println("Map after keySet Modification "+marks);
    }
}
