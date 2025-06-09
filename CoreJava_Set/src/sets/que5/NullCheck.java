package sets.que5;

import java.util.TreeSet;

/***
 How does TreeSet handle null elements?
 TreeSet does not allow null unless it’s empty and no comparator is used.
 Add a few integers to TreeSet, then try adding null. Analyze the exception thrown
 */
public class NullCheck {
    public static void main(String[] args) {
        TreeSet<Integer>treeSet=new TreeSet<>();

        treeSet.add(10);
        treeSet.add(20);
        treeSet.add(30);

        System.out.println("Tree set before adding null "+treeSet);

        try {
            treeSet.add(null);

        }catch (NullPointerException e){
            System.out.println(" Exception occured while adding null");
        }

        System.out.println("Treeset after attempt "+treeSet);
    }
}
