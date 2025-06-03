package ArrayList.que4;

import java.util.ArrayList;
import java.util.List;

public class NullCheck {
    public static void main(String[] args) {
        List<String>list=new ArrayList<>();
        list.add("Sumit");
        list.add(null);
        list.add("Shubham");
        list.add(null);
        list.add("Rohit");
        list.add(null);

        System.out.println("Original List "+list);

        boolean hasNull=list.contains(null);
        System.out.println("Contains null "+hasNull);

        list.remove(null);
        System.out.println("After removing one null "+list);

        long nullCount=list.stream().filter(e->e==null).count();
        System.out.println("Remaining null count "+nullCount);
    }
}
