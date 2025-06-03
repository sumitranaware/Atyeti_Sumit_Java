package ArrayList.que8;

import java.util.ArrayList;
import java.util.List;

public class SubList {
    public static void main(String[] args) {
        List<String>originalList=new ArrayList<>();
        for (int i=1;i<=10;i++){
            originalList.add("Item"+i);
        }

        System.out.println("Original List: "+originalList);

        List<String>subList=originalList.subList(2,5);
        System.out.println("Sublist before modification "+subList);
        System.out.println(originalList);

        subList.set(0,"modifiedItem");

        System.out.println("\nAfter modification sublist");
        System.out.println("Sublist "+subList);
        System.out.println("Original list "+originalList);

        subList.clear();

        System.out.println("\nAfter clearing subList:");
        System.out.println("SubList: " + subList);
        System.out.println("Original List: " + originalList);


    }
}
