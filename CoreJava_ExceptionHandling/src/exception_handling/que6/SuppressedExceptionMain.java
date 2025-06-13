package exception_handling.que6;

public class SuppressedExceptionMain {
    public static void main(String[] args) {
        try (AutoClosableImpl autoClosable = new AutoClosableImpl()) {
            System.out.println(" Inside try block...");
            throw new Exception("Exception from try block");
        } catch (Exception e) {
            System.out.println("Caught main exception  " + e.getMessage());


            for (Throwable suppressed :e.getSuppressed()){
                System.out.println("Suppressed "+suppressed.getMessage());
            }
        }
    }
}