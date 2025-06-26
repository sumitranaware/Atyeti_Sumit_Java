package virtual_threads.que2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PlatformvsVirtualComparison {
    static final int NUM_TASKs = 10;

    public static void main(String[] args) {
        System.out.println("Starting platform thread execution");
        try {
            runTest(Executors.newVirtualThreadPerTaskExecutor(), " Virtual Thread");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    private static void runTest(ExecutorService executorService,String label)throws InterruptedException{
        long memBefore=usedMemory();
        long start=System.currentTimeMillis();

        CountDownLatch latch=new CountDownLatch(NUM_TASKs);

        for (int i=0;i<NUM_TASKs;i++ ) {
            executorService.submit(() -> {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    latch.countDown();
                }
            });
        }
            latch.await();
            long duration = System.currentTimeMillis() - start;
            long memAfter = usedMemory();

            executorService.shutdown();
            System.out.println("Executor "+label);
            System.out.println("Time taken "+duration+" ms");
            System.out.println("Memory used "+(memAfter-memBefore)/1024+" kb");



        }




    private static long usedMemory() {
        Runtime runtime=Runtime.getRuntime();
        return runtime.totalMemory()- runtime.freeMemory();
    }
}
