package executor_framework.que5;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class IOTSensorScheduler {
    public static void main(String[] args) {
        ScheduledExecutorService schedule= Executors.newScheduledThreadPool(2);
        Random random=new Random();
        Runnable fixedRateSensor=()->{
            String name=" FixedRateSensor";
            String thread=Thread.currentThread().getName();
            int delay=1000+ random.nextInt(4000);
            System.out.println("Start "+name+" on "+thread+" | delay= "+delay+" ms");
            try{
                Thread.sleep(delay);

            } catch (InterruptedException e) {
                System.out.println("Interrupted "+name);
            }
            System.out.println("End "+name+" on "+thread);
        };
        Runnable fixedDelaySensor=()->{
            String name="Fixed delay sensor ";
            String thread=Thread.currentThread().getName();
            int delay=1000+ random.nextInt(4000);

            System.out.println("Start "+name+" on "+thread+" | delay "+delay+" ms");
            try{
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("End "+name+" on "+thread);
        };
        schedule.scheduleAtFixedRate(fixedRateSensor,0,3, TimeUnit.SECONDS);
        schedule.scheduleAtFixedRate(fixedDelaySensor,0,3,TimeUnit.SECONDS);

        schedule.schedule(()->{
            System.out.println(" Shutting down scheduler");
            schedule.shutdown();
        },30,TimeUnit.SECONDS);


    }
}
