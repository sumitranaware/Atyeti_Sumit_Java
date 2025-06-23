package executor_framework.que1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorMiniUseCase {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(2);
        for (int i=0;i<=5; i++){
            int requestId=i;
            executorService.submit(()->{
                System.out.println("Start Request "+requestId+" by "+Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    System.out.println("End Request "+requestId+" by "+Thread.currentThread().getName());
                }
            });

        }
    }
}
