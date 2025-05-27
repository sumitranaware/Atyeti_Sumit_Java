public class VolatileExample {
    public static void main(String[] args) {
          SharedResource sharedResource=new SharedResource();

          Thread writerThread=new Thread(()->{
              try{
                  Thread.sleep(1000);
              } catch (InterruptedException e) {
                  Thread.currentThread().interrupt();
              }
              sharedResource.setFlagTrue();
          });
         Thread readerThread=new Thread(()->sharedResource.printIfFlagTrue());
         writerThread.start();
         readerThread.start();
    }
}
