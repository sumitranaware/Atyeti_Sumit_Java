package QueueAndDeque.que1;

import java.util.PriorityQueue;

/***
 PriorityQueue Ordering
 Problem: Add integers in random order. Observe how they are retrieved.
 */
public class PriorityQueueNaturalOrder {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>();
        priorityQueue.add(50);
        priorityQueue.add(10);
        priorityQueue.add(40);
        priorityQueue.add(20);
        priorityQueue.add(30);

        System.out.println("Retrieved in sorted order");
        while (!priorityQueue.isEmpty()){
            System.out.println(priorityQueue.poll()+" ");
        }

    }
}
/***
 Note
 PriorityQueue stores elements in a heap structure.
 The order of iteration is not sorted,
 but poll() always returns the lowest (natural order) element.
 */