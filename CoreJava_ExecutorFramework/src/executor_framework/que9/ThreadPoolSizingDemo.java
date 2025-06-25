package executor_framework.que9;

import javax.swing.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolSizingDemo {
    public static void main(String[] args) {
        int cores=Runtime.getRuntime().availableProcessors();
        System.out.println("Available cores "+cores);

        ExecutorService ioBoundPool= Executors.newFixedThreadPool(cores*4);
        ExecutorService cpuBoundPool=Executors.newFixedThreadPool(cores+1);

        Runnable ioTask=()->{
            try{
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        Runnable cpuTask=()->{
            long sum=0;
            for (int i=0;i<1_000_000;i++)sum+=i;

        };
        long ioStart=System.currentTimeMillis();
        for (int i=0;i<1000;i++)ioBoundPool.submit(ioTask);
        ioBoundPool.shutdown();
        try{
            ioBoundPool.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("IO Task completed in "+(System.currentTimeMillis()-ioStart)+" ms");

         long cpuStart =System.currentTimeMillis();
         for (int i=0;i<1000;i++)cpuBoundPool.submit(cpuTask);
         cpuBoundPool.shutdown();
         try{
             cpuBoundPool.awaitTermination(10,TimeUnit.SECONDS);
         } catch (InterruptedException e) {
             throw new RuntimeException(e);

         }
        System.out.println("CPU Task completed in: "+(System.currentTimeMillis()-cpuStart));

    }
}
