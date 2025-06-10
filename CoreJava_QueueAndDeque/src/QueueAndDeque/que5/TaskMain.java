package QueueAndDeque.que5;

import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class TaskMain {
    public static void main(String[] args) {
        PriorityBlockingQueue<Task>queue=new PriorityBlockingQueue<>();

        Runnable producer1=()-> {
            queue.add(new Task("A", 3));
            queue.add(new Task("B", 1));
        };
            Runnable producer2=()->{
                queue.add(new Task("C",2));
                queue.add(new Task("D",4));
            };

            Thread t1=new Thread(producer1);
            Thread t2=new Thread(producer2);

            t1.start();
            t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("\n retrieving tasks by priority");
        while (!queue.isEmpty()){
            try {
                System.out.println(queue.take());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        }
    }

