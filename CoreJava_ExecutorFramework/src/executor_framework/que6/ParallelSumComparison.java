package executor_framework.que6;

import java.util.concurrent.*;

public class ParallelSumComparison {
    public static void main(String[] args) {
            int[]data=new int[10_000_000];
            for (int i=0;i<data.length;i++)data[i]=i+1;
System.out.println(" starting forkjoinpool computation...");
            ForkJoinPool forkJoinPool=new ForkJoinPool();
            long start1=System.currentTimeMillis();
            long sum=forkJoinPool.invoke(new ArraySumTask(data,0,data.length));
            long end1=System.currentTimeMillis();

            System.out.println(" sum forkjoin "+sum+" in "+(end1-start1)+" ms");
            System.out.println( "Starting threadpool computation computation");
            ExecutorService executor= Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
            int chunkSize =data.length/10;

            Future[] result=new Future[10];
            long start2=System.currentTimeMillis();
            for (int i=0;i<10;i++){
                int start=i*chunkSize;
                int end=(i==9)?data.length:(i+1)*chunkSize;
                int finalStart=start,finalEnd=end;
                result[i]=executor.submit(()->{
                    long localSum=0;
                    for (int k=finalStart;k<finalEnd;k++)localSum+=data[k];
                    return localSum;
                });

            }
            long sum2=0;
            for (Future<Long>f:result) {
                try {
                    sum2+=f.get();
                    long end2=System.currentTimeMillis();

                    executor.shutdown();
                    System.out.println("Sum threadpoolexecutor "+sum2+" in " +(end2-end2)+" ms");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
