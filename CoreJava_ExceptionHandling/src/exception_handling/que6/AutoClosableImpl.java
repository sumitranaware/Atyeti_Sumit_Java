package exception_handling.que6;

public class AutoClosableImpl implements AutoCloseable{

    @Override
    public void close() throws Exception {
        System.out.println("Closing resource ");
        throw  new Exception("Exception from close()");
    }
}
