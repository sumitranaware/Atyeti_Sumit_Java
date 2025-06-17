package stream_api.que4;

import java.util.List;

public class ShortCircuiting {
    public static void main(String[] args) {
        List<String>names=List.of("Sumit","Shubham","Rohit","Pranav","Lokesh");
        System.out.println("Part A");
        names.stream()
                .peek(n-> System.out.println("Peek 1: "+n))
                .filter(n->n.startsWith("S"))
                .peek(n-> System.out.println("After filter "+n))
                .limit(2)
                .peek(n-> System.out.println("After limit "+n))
                .forEach(System.out::println);

        System.out.println("Part B");
        names.stream()
                .peek(n-> System.out.println("Peek 2 "+n))
                .map(String::toUpperCase)
                .peek(n-> System.out.println("Mapped "+n))
                .filter(n->n.startsWith("S"))
                .findFirst()
                .ifPresent(System.out::println);

        System.out.println("Part C ");
        names.stream()
                .peek(n-> System.out.println("Peek 3 "+n))
                .map(String::toLowerCase)
                .peek(n-> System.out.println("Mapped "+n))
                .anyMatch(n->n.contains("Sum"));
    }
}
