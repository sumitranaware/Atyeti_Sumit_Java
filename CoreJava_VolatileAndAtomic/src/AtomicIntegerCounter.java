import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerCounter {
    private AtomicInteger counter=new AtomicInteger();

    public void increment(){
        counter.incrementAndGet();
    }
    public int getCounter(){
        return counter.get();
    }

}
