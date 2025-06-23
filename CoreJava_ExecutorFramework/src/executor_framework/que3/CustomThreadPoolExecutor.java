package executor_framework.que3;

import java.util.concurrent.*;

public class CustomThreadPoolExecutor {
    public static ThreadPoolExecutor createExecutor(){
        int corePoolSize =2;
        int maxPoolSize=4;
        int keepAliveTime=10;

        BlockingQueue<Runnable> blockingQueue=new ArrayBlockingQueue<>(2);

        RejectedExecutionHandler handler=new ThreadPoolExecutor.CallerRunsPolicy();

        return new ThreadPoolExecutor(
                corePoolSize,
                maxPoolSize,
                keepAliveTime,
                TimeUnit.SECONDS,
               blockingQueue,
                Executors.defaultThreadFactory(),
                handler

        );

    }
}
