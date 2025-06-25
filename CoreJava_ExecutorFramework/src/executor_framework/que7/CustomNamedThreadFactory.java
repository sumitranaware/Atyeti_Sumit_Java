package executor_framework.que7;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class CustomNamedThreadFactory implements ThreadFactory {
    private  final String baseName;
    private final boolean daemon;
    private final int priority;
    private final AtomicInteger count=new AtomicInteger(1);

    public CustomNamedThreadFactory(String baseName, boolean daemon, int priority) {
        this.baseName = baseName;
        this.daemon = daemon;
        this.priority = priority;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t=new Thread(r);
        t.setName(baseName+"-"+count.getAndIncrement());
        t.setDaemon(daemon);
        t.setPriority(priority);
        return t;
    }
}
