package stream_api.que5;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.stream.Stream;

public class StructuralModification {
    public static void main(String[] args) {
        List<String>names=new ArrayList<>(List.of("Sumit","Shreeraj","Raj"));
        Stream<String>stream=names.stream();

        names.add("Indrajeet");
        names.add("Siddhesh");

        System.out.println("Stream output");
        try{
            stream.forEach(System.out::println);

        }catch (ConcurrentModificationException e){
            System.out.println("Caught Exception");
        }
    }
}
