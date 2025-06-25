package executor_framework.que8;

import executor_framework.que7.CustomNamedThreadFactory;

import java.util.concurrent.*;

public class ThreadPoolMonitor {
    public static void main(String[] args) {
        ThreadPoolExecutor executor=new ThreadPoolExecutor(
                2,4,10, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(100),
                new CustomNamedThreadFactory("monitor-worker",false,Thread.NORM_PRIORITY)

        );
        for (int i=1;i<=20;i++){
            executor.submit(()->{
                try{
                    Thread.sleep(5000);
                }catch (InterruptedException e){}
            });
        }
        ScheduledExecutorService monitor= Executors.newSingleThreadScheduledExecutor();
        monitor.scheduleAtFixedRate(()->printStats(executor),0,2,TimeUnit.SECONDS);

        monitor.schedule(()->{
            executor.shutdown();
            monitor.shutdown();
            System.out.println("Monitoring stopped");
        },30,TimeUnit.SECONDS);
        executor.shutdown();
    }

    private static void printStats(ThreadPoolExecutor executor){
        System.out.println("Pool Size "+executor.getPoolSize()
        +" Active "+executor.getActiveCount()
                +" queue "+executor.getQueue().size()
                +" Task submitted "+ executor.getTaskCount()
                +" completed "+executor.getCompletedTaskCount()


        );
    }
}
