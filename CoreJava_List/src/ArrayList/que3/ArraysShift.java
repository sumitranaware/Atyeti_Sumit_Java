package ArrayList.que3;

import java.util.ArrayList;
import java.util.List;

/***
 Question 3: What happens to element positions when inserting or removing in an ArrayList?
 Problem Statement:
 Create an ArrayList of integers from 1 to 10.
 Insert 99 at index 4.
 Print the list – ensure elements from index 4 onwards are shifted one place right.
 Remove the element at index 4 and ensure the list returns to its original order.
 */
public class ArraysShift {
    public static void main(String[] args) {
        List<Integer>list=new ArrayList<>();

        for (int i=1;i<=10;i++){
            list.add(i);
        }

        System.out.println("Original List "+list);

        list.add(4,99);
        System.out.println("After adding 99 at index 4 "+list);

        list.remove(4);
        System.out.println("After removing the element at index 4: "+list);
    }
}
