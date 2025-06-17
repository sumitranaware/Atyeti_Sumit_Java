package stream_api.que2;

import java.util.List;
import java.util.stream.Collectors;

/***
 Does the order of intermediate operations (e.g., filter(), map(), sorted(), distinct()) affect performance or output? Explain with scenarios
 */
public class IntermediateStreamOrder {
    public static void main(String[] args) {
        List<String>names=List.of("sumit","Shubham","ROHIT","pranav","SUMIT","Lokesh");
       long startTime=System.nanoTime();
        List<String>result=names.stream()
                .peek(s-> System.out.println("Original "+s))
                .map(String::toLowerCase)
                .peek(s-> System.out.println("Lowercase "+s))
                .filter(s->s.startsWith("s"))
                .peek(s-> System.out.println("Filtered starts with s "+s))
                .sorted()
                .peek(s-> System.out.println("After sort "+s))
                .limit(2)
                .peek(s-> System.out.println("After limit "+s))
                .toList();
long endTime=System.nanoTime();

        System.out.println("Final Result "+result);
        System.out.println("Time taken "+(endTime-startTime)+"ms");
    }
}
