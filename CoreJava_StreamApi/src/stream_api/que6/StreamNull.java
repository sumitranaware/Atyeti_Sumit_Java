package stream_api.que6;

import org.w3c.dom.ls.LSException;

import java.util.List;
import java.util.stream.Collectors;

public class StreamNull {
    public static void main(String[] args) {
        List<String>items= List.of("apple","banana","null","avacado","grape");

        List<String>result=items.stream()
                .map(s->s.equals("null")?null:s.toUpperCase())
                .filter(s->s.startsWith("A"))
                .sorted()
                .collect(Collectors.toList());
    }
}
