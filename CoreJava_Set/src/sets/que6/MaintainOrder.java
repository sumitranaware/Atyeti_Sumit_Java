package sets.que6;

import java.util.LinkedHashSet;

/***

 */
public class MaintainOrder {
    public static void main(String[] args) {
        LinkedHashSet <String> set=new LinkedHashSet<>();
        set.add("A");
        set.add("B");
        set.add("C");
        set.add("D");

        System.out.println("Initial set "+set);

        set.remove("B");
        set.add("B");

        System.out.println("After removing and re adding b" +set);

    }
}
