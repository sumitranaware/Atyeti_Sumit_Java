package ArrayList.que5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/***
 How does ArrayList handle concurrent modification?
 🔍 Problem Statement:
 Create an ArrayList with a few elements.
 Iterate over the list using an enhanced for-loop.
 Try to add/remove elements during iteration.
 Observe the ConcurrentModificationException.
 */

public class ConcurrentModification {
    public static void main(String[] args) {
        List<String>items=new ArrayList<>();
        items.add("Apple");
        items.add("Banana");
        items.add("cherry");

        Iterator<String>iterator=items.iterator();
        while (iterator.hasNext()){
            String item=iterator.next();
            if(item.equals("Banana")){
                iterator.remove();
            }
        }
        System.out.println(items);
    }
}
