package executor_framework.que10;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GracefulShutdownDemo {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(2);
        Runnable task=()->{
            String thread=Thread.currentThread().getName();
            try{
                System.out.println("Task started in "+thread);
                Thread.sleep(5000);
                System.out.println("Task finished in "+ thread);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        for (int i=0;i<3;i++){
            executorService.submit(task);
        }
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(10, TimeUnit.SECONDS)){
                System.out.println("Still not terminated");
            }
           else {
                System.out.println("Executor Terminated");
            }
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
