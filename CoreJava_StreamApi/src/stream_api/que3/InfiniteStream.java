package stream_api.que3;

import stream_api.que2.IntermediateStreamOrder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Problem: Generate an infinite stream of natural numbers starting from 1.
// Return the first 5 even numbers greater than 10.
public class InfiniteStream {
    public static void main(String[] args) {
        List<Integer>result= Stream.iterate(1,n->n+1)
                .filter(n->n%2==0)
                .limit(5)
                .collect(Collectors.toList());
        System.out.println(result);
    }

}
