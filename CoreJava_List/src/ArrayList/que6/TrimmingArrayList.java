package ArrayList.que6;

import java.util.ArrayList;

/***
 What is the effect of trimming an ArrayList?
 Problem Statement:
 Add 1000 elements to an ArrayList.
 Remove 900 elements.
 Call .trimToSize().
 Analyze how it affects the internal capacity and memory usage.
 */
public class TrimmingArrayList {
    public static void main(String[] args) {
        ArrayList<Integer>list=new ArrayList<>();
        for (int i=0;i<1000;i++){
            list.add(i);
        }
        System.out.println("Size before removal "+list.size());


        for (int i=0;i<900;i++){
            list.remove(0);
        }

        System.out.println("Size after removal "+list.size());

        list.trimToSize();
        System.out.println("Called the trimToSize ");

        System.gc();

        System.out.println("Final list size "+ list.size());
    }



}
