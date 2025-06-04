package LinkedList.que4;

import java.util.LinkedList;
import java.util.List;

public class NestedLinkedList {
    public static void main(String[] args) {
        LinkedList<LinkedList<String>>outerList=new LinkedList<>();

        LinkedList<String>fruits=new LinkedList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Mango");


        LinkedList<String>cities=new LinkedList<>();
        cities.add("Pune");
        cities.add("Mumbai");
        cities.add("Delhi");

        LinkedList<String>languages=new LinkedList<>();
        languages.add("Java");
        languages.add("Python");
        languages.add("C++");

        outerList.add(fruits);
        outerList.add(cities);
        outerList.add(languages);


        System.out.println("original Linked List");
        printNestedList(outerList);

        outerList.get(0).set(1,"grapes");

        outerList.get(1).remove("Delhi");

        outerList.get(2).add("GO");

        System.out.println("\nAfter modification");
        printNestedList(outerList);

    }
    public static void printNestedList(LinkedList<LinkedList<String>>outerList){
        int index=1;
        for (LinkedList<String>innerList:outerList){
            System.out.println("List "+index++ +" "+innerList);
        }
    }
}
