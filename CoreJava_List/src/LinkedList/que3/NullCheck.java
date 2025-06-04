package LinkedList.que3;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.LinkedList;

/***
 Does LinkedList allow nulls?
 Problem: Add multiple nulls, check .contains(null), .remove(null), and count using streams.
 */

public class NullCheck {
    public static void main(String[] args) {
        LinkedList<String>list=new LinkedList<>();
        list.add("Java");
        list.add(null);
        list.add("Python");
        list.add(null);
        list.add("C++");

        System.out.println("Original List "+list );

        System.out.println("Contains null "+list.contains(null));

        list.remove();
        System.out.println("After removing one null "+list);

        long nullCount=list.stream().filter(e->e==null).count();
        System.out.println("Remaining null count "+nullCount);






    }
}
