package exception_handling.que4;

public class FinallyBehaviour {
    public int test1(){
        try{
            return 1;

        }finally {
            System.out.println("Test 1 finally executed");
        }
    }
    public int test2(){
        try{
            return 1;

        }finally {
            System.out.println("Test 2 finally executed");
            return 2;
        }
    }
    public int test3(){
        try{
            int a=1/0;
            return 1;
        }
        catch (ArithmeticException e){
            System.out.println("Test 3 caught exception");
            return 3;
        }finally {
            System.out.println("Test 3 finally runs even after exception");
        }
    }
    public int test4(){
        try{
            int a=1/0;

        }catch (ArithmeticException e){
            System.out.println("Test 4 caught exception returning 4");
            return 4;
        }finally {
            System.out.println("  Test4: Finally returns 5");
            return 5;
        }
    }
    public int test5(){
        try{
            int a=1/0;

        }catch (NullPointerException e){
            System.out.println("Test 5 this will not catch arithmeticException");
        }
        finally {
            System.out.println("Test 5: finally still runs");
        }
        return  0;
    }
}
