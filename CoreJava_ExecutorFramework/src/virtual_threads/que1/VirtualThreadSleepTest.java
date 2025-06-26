package virtual_threads.que1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/***
 Create 100,000 virtual threads that simulate an I/O delay using Thread.sleep(1000) and measure time
 */
public class VirtualThreadSleepTest {
    public static void main(String[] args) {
        int numberOfTasks=100_000;

        long start=System.currentTimeMillis();
        ExecutorService executorService= Executors.newVirtualThreadPerTaskExecutor();
        for (int i=0;i<numberOfTasks;i++) {
            executorService.submit(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }
            executorService.shutdown();
            try {
                executorService.awaitTermination(2, TimeUnit.MINUTES);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        long duration =System.currentTimeMillis()-start;
        System.out.println("all task completed");
        System.out.println("Total time: "+duration+" ms");
    }
}

