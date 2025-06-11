package neststed_collections.que7;

import java.util.*;

/***
 Map with Set as Key
 Create a Map<Set<String>, String>, add entries with different Set orders, and observe behavior. Discuss hashCode/equals dependency.
 */
public class SetKeyDemo {
    public static void main(String[] args) {
        Map<Set<String >,String>map=new HashMap();
        Set<String>set1=new HashSet<>(Arrays.asList("A","B","C"));
        Set<String>set2=new HashSet<>(Arrays.asList("C","B","A"));

        map.put(set1,"First Entry");
        map.put(set2,"Second Entry");

        System.out.println("Map size " +map.size());
        for (Map.Entry<Set<String>,String>entry:map.entrySet()){
            System.out.println("Key "+entry.getKey()+" value "+entry.getValue());

        }

        System.out.println("Set1.equals(set2) "+set1.equals(set2));
        System.out.println("set1.hashCode() == set2.hashCode(): " + (set1.hashCode() == set2.hashCode()));
    }
}
