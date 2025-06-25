package executor_framework.que4;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class RetryHealthCheck {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler= Executors.newScheduledThreadPool(1);
        Runnable healthTask=()->{
            String thread=Thread.currentThread().getName();
            System.out.println(" Checking server health on: "+thread);
            try{
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("Interrupted ");
            }
        };
        scheduler.schedule(()->{
            System.out.println("Shutting down scheduler ");
            scheduler.shutdown();

        },30, TimeUnit.SECONDS);
    }
}
