package virtual_threads.que3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VirtualThreadFileIO {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newVirtualThreadPerTaskExecutor();
        for (int i=0;i<100;i++){
            int id=i;
            executorService.submit(()->{
                try (BufferedReader bufferedReader=new BufferedReader(new FileReader("C:\\Users\\SumitRanaware\\OneDrive - Atyeti Inc\\Desktop\\Atyeti_Sumit_Java\\CoreJava_ExecutorFramework\\src\\virtual_threads\\que3\\sample.txt"))){
                    System.out.println("Reading file in task "+id+" by "+Thread.currentThread());
                    while (bufferedReader.readLine()!=null){}
                    System.out.println("Task "+id+" completed ");
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            });

        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
