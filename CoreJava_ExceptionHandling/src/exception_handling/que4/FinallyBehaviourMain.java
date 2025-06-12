package exception_handling.que4;

public class FinallyBehaviourMain {
    public static void main(String[] args) {
        FinallyBehaviour finallyBehaviour=new FinallyBehaviour();

        System.out.println("Test1 (return in try): " + finallyBehaviour.test1());
        System.out.println("Test2 (return in try & finally): " + finallyBehaviour.test2());
        System.out.println("Test3 (exception in try, return in catch): " + finallyBehaviour.test3());
        System.out.println("Test4 (exception in try, return in catch & finally): " + finallyBehaviour.test4());

        try{
            System.out.println("test 5 (uncaught exception in try)"+ finallyBehaviour.test5());
        }catch (Exception e){
            System.out.println("Cought in main "+e);
        }
    }
}
