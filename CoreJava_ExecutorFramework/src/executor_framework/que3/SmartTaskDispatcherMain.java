package executor_framework.que3;

import java.sql.SQLOutput;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SmartTaskDispatcherMain {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor=CustomThreadPoolExecutor.createExecutor();
        int fallbackcount =0;
        for (int i=1;i<=10;i++){
            String name="Task "+i;
            Runnable task=new Task(name);

            System.out.println("Submitting "+name+
                    "Active thread "+threadPoolExecutor.getActiveCount()+
            "Queue size "+threadPoolExecutor.getQueue().size());

            int before =Thread.activeCount();
            threadPoolExecutor.execute(task);
            int after =Thread.activeCount();

            threadPoolExecutor.shutdown();
            try {
                if(!threadPoolExecutor.awaitTermination(10, TimeUnit.SECONDS)){
                    System.out.println("Time out forcing shutdown");
                    threadPoolExecutor.shutdown();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(" Dispatch complete fallback to main thread ");
        }
    }
}
