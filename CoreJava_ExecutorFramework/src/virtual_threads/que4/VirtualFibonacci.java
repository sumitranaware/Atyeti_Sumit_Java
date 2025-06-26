package virtual_threads.que4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class VirtualFibonacci {
    private final ExecutorService executorService;

    public VirtualFibonacci(ExecutorService executorService) {
        this.executorService = executorService;
    }
    public Future<Integer>fib(int n){
        return executorService.submit(()->{
            if (n<=1)return n;
            Future<Integer>f1=fib(n-1);
            Future<Integer>f2=fib(n-2);
            return f1.get()+ f2.get();
        });
    }
}
