package executor_framework.que3;

public class Task implements Runnable{
    private final String taskName;
    public Task(String name){
        this.taskName=name;
    }
    public void run(){
        String threadName=Thread.currentThread().getName();
        System.out.println("Start "+taskName+" on "+threadName);
        try{
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("end  "+taskName+" on "+threadName);
    }
}
