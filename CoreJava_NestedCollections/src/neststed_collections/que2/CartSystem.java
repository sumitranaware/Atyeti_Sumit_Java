package neststed_collections.que2;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/***
 2. List<Map<String, Integer>> — Cart System (Multiple Orders)
 Each Map<String, Integer> represents one order → item name and quantity.
 List<Map<String, Integer>> holds multiple such orders.
 This is very common in e-commerce apps where each customer places multiple orders.
 */
public class CartSystem {
    public static void main(String[] args) {
        Map<String, Integer>order1=Map.of("apple",1,"banana",3);
        Map<String,Integer>order2=Map.of("banana",1,"orange",4);
        Map<String,Integer>order3=Map.of("apple",1,"orange",1);

        List<Map<String,Integer>>orders=List.of(order1,order2,order3);

        Map<String , Integer>summary=orders.stream()
                .flatMap(map-> map.entrySet().stream())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        Integer::sum
                ));

        System.out.println("Total quantity of each item ");
        summary.forEach((item,quantity)-> System.out.println(item+" "+quantity));
    }
}
