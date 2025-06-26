package virtual_threads.que4;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

public class Main1 {
    public static void main(String[] args) {


        int fibNum = 20;
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        long start1 = System.currentTimeMillis();
        int result1 = forkJoinPool.invoke(new WithForkJoinPool(fibNum));

        long end1 = System.currentTimeMillis();
        System.out.println("Fork join result " + result1 + " in " + (end1 - start1) + " ms");

        ExecutorService virtualService = Executors.newVirtualThreadPerTaskExecutor();
        VirtualFibonacci virtualFibonacci = new VirtualFibonacci(virtualService);
        long start2 = System.currentTimeMillis();
        int result2;
        try {
            result2 = virtualFibonacci.fib(fibNum).get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        long end2 = System.currentTimeMillis();

        System.out.println("Virtual thread result" + result2 +" in "+(end2-start2)+ " ms");

        virtualService.shutdown();
    }
}