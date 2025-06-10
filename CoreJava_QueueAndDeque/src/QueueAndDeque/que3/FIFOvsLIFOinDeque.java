package QueueAndDeque.que3;

import java.util.ArrayDeque;
import java.util.Deque;

/***
 FIFO vs LIFO Behavior with Deque
 Deque can act as both a Queue (FIFO) and a Stack (LIFO).
 Problem: Use addFirst()/removeLast() and addLast()/removeFirst() to simulate both behaviors. Observe the output.
 */
public class FIFOvsLIFOinDeque {
    public static void main(String[] args) {
        Deque<String> dequeFifo =new ArrayDeque<>();
        dequeFifo.addLast("A");
        dequeFifo.addLast("B");
        dequeFifo.addLast("C");

        System.out.println("FIFO  Queue order");
        while(!dequeFifo.isEmpty()){
            System.out.println(dequeFifo.removeFirst());
        }

        Deque<String>dequeLifo=new ArrayDeque<>();
        dequeLifo.addFirst("A");
        dequeLifo.addFirst("B");
        dequeLifo.addFirst("C");
        dequeLifo.addFirst("D");

        System.out.println("LIFO Queue order"  );
        while (!dequeLifo.isEmpty()){
            System.out.println(dequeLifo.removeFirst());
        }
    }
}
