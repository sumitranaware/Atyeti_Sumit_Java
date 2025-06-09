package sets.que7;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/***
 When is it better to use Set instead of List?
 When uniqueness is required, especially for large datasets or lookup operations.
 Problem:
 Compare memory and performance of List.contains() vs Set.contains() for 100,000 elements
 */
public class SetvsList {
    public static void main(String[] args) {
        int dataSize=100_000;
        List<Integer>list=new ArrayList<>();
        Set<Integer>set=new HashSet<>();

        for (int i=0;i<dataSize;i++){
            list.add(i);
            list.add(i);
        }
        int searchElement=dataSize-10;

        long listStart=System.nanoTime();
        boolean listFound=list.contains(searchElement);
        long listEnd=System.nanoTime();

        long setStart=System.nanoTime();
        boolean setFound=set.contains(searchElement);
        long setEnd=System.nanoTime();

        System.out.println("List.contains() -> Found: " + listFound + " | Time: " + (listEnd - listStart) + " ns");
        System.out.println("Set.contains()  -> Found: " + setFound + " | Time: " + (setEnd - setStart) + " ns");

    }
}
