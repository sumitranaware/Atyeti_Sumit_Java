package exception_handling.que1;

public class ExceptionPropagation {
    public static void main(String[] args) {
        try {
            methodA();
        } catch (MyCheckedException e) {
            System.out.println("Exception Handled in main()");
            e.printStackTrace();
        }
    }
        static void methodA()throws MyCheckedException{
            System.out.println("In MethodA()");
            methodB();
        }
        static void methodB()throws MyCheckedException {
            System.out.println("In Method B");
            try {
                methodC();

            } catch (MyCheckedException e) {
                System.out.println(" Partially handled in methodB now rethrowing");
                throw e;
            }
        }
            static void methodC() throws MyCheckedException{
                System.out.println("In methodC");
                throw new MyCheckedException("Exception thrown from methodC");
            }
        }
