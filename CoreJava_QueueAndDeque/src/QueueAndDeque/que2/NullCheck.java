package QueueAndDeque.que2;

import java.util.*;

public class NullCheck {
    public static void main(String[] args) {
        Queue<String>priorityQueue=new PriorityQueue<>();

        try{
            priorityQueue.add(null);

        }catch (NullPointerException e){
            System.out.println("Priority que does not allow null "+e);
        }

        Deque<String>arrayDeque=new ArrayDeque<>();
        try{
            arrayDeque.add(null);

        }catch (NullPointerException e){
            System.out.println("ArrayDeque does not allow null");
        }

        Queue<String>linkedListQueue=new LinkedList<>();
        linkedListQueue.add(null);

        System.out.println("Linked list queue head is null "+linkedListQueue.peek());
    }
}
