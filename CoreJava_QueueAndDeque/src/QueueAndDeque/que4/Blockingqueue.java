
package QueueAndDeque.que4;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/***
 BlockingQueue Usage (Concurrency)
 Insight: BlockingQueue like LinkedBlockingQueue and ArrayBlockingQueue block threads on full/empty.
 Problem:
 Start a producer thread that adds elements.
 Start a consumer thread that takes elements.
 Simulate blocking behavior and thread-safe transfer.
 */



public class Blockingqueue {
    public static void main(String[] args) {
        BlockingQueue<Integer> blockingqueue=new ArrayBlockingQueue<>(5);

        Runnable producer=()->{
            for (int i=1;i<=10;i++){
                try{
                    System.out.println("Producer trying to add "+i);
                    blockingqueue.put(i);
                    System.out.println("Producer added "+i);
                    Thread.sleep(300);

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Runnable consumer=()->{
            for (int i=1;i<=10;i++){
                try{
                    Thread.sleep(1000);
                    int item=blockingqueue.take();
                    System.out.println("Consumer took "+item);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread producerThread=new Thread(producer);
        Thread consumerThread=new Thread(consumer);
        producerThread.start();
        consumerThread.start();

    }
}
