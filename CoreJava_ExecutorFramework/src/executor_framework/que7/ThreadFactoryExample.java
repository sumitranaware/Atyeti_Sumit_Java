package executor_framework.que7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class ThreadFactoryExample {
    public static void main(String[] args) {
        ThreadFactory factory=new CustomNamedThreadFactory("worker",false,Thread.NORM_PRIORITY);

        ExecutorService executorService=Executors.newFixedThreadPool(3,factory);

        for (int i=1;i<=5;i++){
            executorService.submit(()->{
                System.out.println("Running in "+Thread.currentThread().getName());
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){

                }
            });

        }
        executorService.shutdown();
    }
}
