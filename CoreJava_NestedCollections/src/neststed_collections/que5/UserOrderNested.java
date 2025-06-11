package neststed_collections.que5;

import java.util.*;

/***
 Map<String, List<Map<String, Object>>> — JSON-like Nested Records
 Simulates JSON where a key maps to a list of object records
 Problem:
 Add multiple records like orders for users
 */
public class UserOrderNested {
    public static void main(String[] args) {
        Map<String, List<Map<String, Object>>>userOrder=new HashMap<>();

        userOrder.put("Sumit",new ArrayList<>(List.of(Map.of("Item","Rice","qnt",2),
                Map.of("Item","Thali","qnt",1)
                )));
        userOrder.put("Shubham",new ArrayList<>(List.of(Map.of("Item","Rice","qnt",1),
        Map.of("Item","Thali","qnt",2)
        )));

        userOrder.computeIfAbsent("Sumit",k->new ArrayList<>())
                .add(Map.of("Item","Paneer","qnt",1));

        System.out.println("User order Summary");
        for (Map.Entry<String,List<Map<String , Object>>>entry:userOrder.entrySet()){
            String user=entry.getKey();
            List<Map<String,Object>>orders=entry.getValue();
            System.out.println(" user "+user);
            for (Map<String,Object>order:orders){
                System.out.println(" "+order.get("Item")+ " "+order.get("qnt"));
            }
        }




    }
}
