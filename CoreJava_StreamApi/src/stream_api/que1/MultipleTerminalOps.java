package stream_api.que1;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/***
 1.	What will happen if you apply multiple terminal operations on a single stream without recreating it? Why?
 */
public class MultipleTerminalOps {
    public static void main(String[] args) {
        List<String>names=List.of("Sumit","Shubham","Rohit");
        //valid
        long count =names.stream().count();
        String joined=names.stream().collect(Collectors.joining(","));

        // invalid usage
        Stream<String>stream=names.stream();
        stream.forEach(System.out::println);
        stream.count();

        //A Java stream is like a one-way ticket: once it's used (via a terminal operation), it's done.
    }
}
