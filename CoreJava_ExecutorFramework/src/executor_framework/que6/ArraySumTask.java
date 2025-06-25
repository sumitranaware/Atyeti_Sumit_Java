package executor_framework.que6;

import java.util.concurrent.RecursiveTask;

public class ArraySumTask extends RecursiveTask<Long> {
      private final int[] array;
      private final int start , end;
      private static final int THRESHOLD =10_000;

    public ArraySumTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if (end-start<=THRESHOLD){
            long sum=0;
            for (int i=start;i<end;i++)sum+=array[i];
            return sum;
        }
        else {
            int mid=(start+end)/2;
            ArraySumTask left=new ArraySumTask(array,start,mid);
            ArraySumTask right=new ArraySumTask(array,mid,end);
            left.fork();
            long rightResult=right.compute();
            long leftResult=left.join();
            return leftResult+rightResult;
        }
    }
}
