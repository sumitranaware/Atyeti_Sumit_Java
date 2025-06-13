package exception_handling.que7;

/***
 Exception Swallowing (Anti-pattern)
 Problem Statement
 Write a method that performs a critical operation (e.g., file save, DB update, or config load). Catch an exception inside it — but leave the catch block empty (swallowing the exception).
 Then observe how the program continues as if everything worked, even though something went wrong.
 */
public class SwallowedException {
    public static void saveData(String input){
        try{
            if(input==null){
                throw new IllegalArgumentException("Input cannot be null");
            }
            System.out.println("Saving data "+input);

        }catch (Exception e){
            // Swallowed — no logging, no throw, no handling
        }
    }
    public static void main(String[] args) {
        saveData(null);
        System.out.println(" data saved successfully ");
    }
}
