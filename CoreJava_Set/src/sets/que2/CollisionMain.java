package sets.que2;

import javax.swing.*;
import java.util.HashSet;
import java.util.Set;

/***
 What’s the cost of adding elements when hash collisions increase?
 High number of collisions can degrade performance to O(n). Internally, HashSet converts the bucket list to a tree after a threshold.
 Problem:
 Create multiple objects with same hashCode and insert them in a HashSet. Measure performance and debug bucket structure.
 */
public class CollisionMain {
    public static void main(String[] args) {


        Set<CollisionObj> set = new HashSet<>();
        int count = 20;
        long start = System.nanoTime();
        for (int i = 0; i < count; i++) {
            set.add(new CollisionObj(i));
        }

        long end =System.nanoTime();
        System.out.println("Inserted "+count+" elements with same hashcode");
        System.out.println("Time takem: "+(end-start)/1_000_000.0 +" ms");
        System.out.println("Set size "+ set.size());
    }
}