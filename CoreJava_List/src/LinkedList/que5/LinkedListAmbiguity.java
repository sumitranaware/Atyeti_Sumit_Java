package LinkedList.que5;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/***
 What is the difference between remove(int index) vs remove(Object o)?
 Problem: Add elements like "5" and 5. Try removing list.remove(5) and list.remove("5"). Understand overload resolution.
 */


public class LinkedListAmbiguity {
    public static void main(String[] args) {
        LinkedList<Object>list=new LinkedList<>();
        list.add("5");
        list.add(5);
        list.add("5");
        list.add(10);
        list.add("5");

        System.out.println("Original List: "+list);

        list.remove("5");
        System.out.println("After list removing 5 "+list);

        list.remove(1);
        System.out.println("After removing 1 "+list);

        list.remove(Integer.valueOf(10));
        System.out.println("After list.remove integer value "+list);
    }
}
