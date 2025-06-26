package virtual_threads.que4;

import java.util.concurrent.RecursiveTask;

public class WithForkJoinPool extends RecursiveTask<Integer> {
             private final int n;

    public WithForkJoinPool(int n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {
        if (n<=1)return n;
        WithForkJoinPool f1=new WithForkJoinPool(n-1);
        f1.fork();
        WithForkJoinPool f2=new WithForkJoinPool(n-2);
        return f2.compute()+f1.compute();
    }
}
