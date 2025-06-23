package executor_framework.que2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class MultiServiceTask {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(3);
        List<Future<String>>futures=new ArrayList<>();
        Random random=new Random();

        for (int i=1;i<=5;i++) {
            int taskId = i;
            Callable<String> task = () -> {
                String threadName = Thread.currentThread().getName();
                int sleepTime = 1000 + random.nextInt(3000);
                System.out.println("Task " + taskId + "started on " + threadName + " will sleep " + sleepTime + " ms");
                Thread.sleep(sleepTime);

                if (random.nextBoolean()) {
                    throw new RuntimeException("Task " + taskId + " failed on " + threadName);
                }
                return " task " + taskId + " completed by " + threadName;

            };
            Future<String> future = executorService.submit(task);
            futures.add(future);
        }
            for (int i=0;i<futures.size();i++){
                Future<String>future=futures.get(i);
                try{
                    String result=future.get(2, TimeUnit.SECONDS);
                    System.out.println("Result "+result);

                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (TimeoutException e) {
                    throw new RuntimeException(e);
                }
            }
            executorService.shutdown();
            try{
                if (!executorService.awaitTermination(5,TimeUnit.SECONDS)){
                    System.out.println(" Forcing shutdown");
                    List<Runnable>droppedTask=executorService.shutdownNow();
                    System.out.println("Unstarted task "+droppedTask.size());
                }
            } catch (InterruptedException e) {
                executorService.shutdown();
            }
        System.out.println(" all tasked processed");
    }
    }

