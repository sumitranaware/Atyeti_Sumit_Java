package QueueAndDeque.que6;

import QueueAndDeque.que4.Blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/***
 Offer vs Add vs Put vs AddAll (Behavior Differences)
 Insight: offer() returns false on failure, add() throws exception, put() blocks.
 Problem: Use ArrayBlockingQueue with limited size. Test how offer(), add(), and put() behave when the queue is full.
 */
public class BehaviourDifference {
    public static void main(String[] args) {
        BlockingQueue<String> queue=new ArrayBlockingQueue<>(4);
        queue.add("A");
        queue.add("B");
        queue.add("C");
        queue.add("D");
        System.out.println("Queue is full "+queue);

        try{
            queue.add("D");

        }catch (IllegalStateException e){
            System.out.println("Add failed "+e.getMessage());
        }

        boolean offered=queue.offer("D");
        System.out.println("offer returned"+offered);

        Thread producer =new Thread(()->{
            try{
                System.out.println("put blocking");
                queue.put("D");
                System.out.println("put completed after space was available");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        producer.start();
        try {
            Thread.sleep(2000);
            System.out.println("Removing "+queue.take());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
