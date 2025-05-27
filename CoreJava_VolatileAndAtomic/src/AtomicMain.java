public class AtomicMain {
    public static void main(String[] args) {
        AtomicIntegerCounter atomicIntegerCounter=new AtomicIntegerCounter();
        Thread t1=new Thread(()->{
            for (int i=0;i<1000;i++){
                atomicIntegerCounter.increment();
            }
        });
        Thread t2=new Thread(()->{
            for (int i=0;i<1000;i++){
                atomicIntegerCounter.increment();
            }
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(atomicIntegerCounter.getCounter());

    }
}
