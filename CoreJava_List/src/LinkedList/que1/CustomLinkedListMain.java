package LinkedList.que1;
/*
How does LinkedList store elements internally?
Problem: Print the structure of LinkedList nodes (node value, next, previous) using custom debugging or toString logic.
 */

public class CustomLinkedListMain {
    public static void main(String[] args) {
        CustomLinkedList<String>list=new CustomLinkedList<>();
        list.add("Sumit");
        list.add("Shreeraj");
        list.add("Raj");
        list.add("Indrajeet");
        list.add("Vedant");

        System.out.println("Linked list internal structure");
        list.printStructure();

    }
}
