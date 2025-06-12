package exception_handling.que2;

import java.io.FileNotFoundException;
import java.io.IOException;

/***
 2. Multiple Catch Blocks — Hierarchy Conflict
 Problem:
 Throw an exception of type FileNotFoundException. Use multiple catch blocks with different orders:
 */
public class MultipleCatchBlock {
    public static void main(String[] args) {
        try{
            throw new FileNotFoundException("File not found");
        }catch (FileNotFoundException e){
            System.out.println("Handled filenotfounexcetion");
        }
        catch (IOException e){
            System.out.println(" Handled IoException");
        }
        catch (Exception e){
            System.out.println(" Handled generic exception");
        }
    }
}
