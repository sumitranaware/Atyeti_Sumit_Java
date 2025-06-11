package neststed_collections.que4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentSubject {
    public static void main(String[] args) {
        Map<String,Map<String,Integer>>studentMarks=new HashMap<>();

        studentMarks.put("Sumit",new HashMap<>(Map.of("Spring",85,"Java",90)));
        studentMarks.put("Shubham",new HashMap<>(Map.of("ML",88,"DL",83)));
        studentMarks.put("Rohit",new HashMap<>(Map.of("DSA",91,"DATA",84)));

        System.out.println("Student marks");
        studentMarks.forEach((student,subjects)->{
            System.out.println(student+" ");
            subjects.forEach((subject,mark)-> System.out.println(" "+subject+" "+mark));
        });
       Map<String,List<Integer>>subjectMarks=new HashMap<>();
       for(Map<String,Integer>subjects:studentMarks.values())
       {
           for (Map.Entry<String,Integer>entry:subjects.entrySet()){
               subjectMarks
                       .computeIfAbsent(entry.getKey(),k->new ArrayList<>())
                       .add(entry.getValue());
           }
       }

        System.out.println("\n average marks per sub");
       subjectMarks.forEach((subject,markList)->{
           double avg=markList.stream().mapToInt(i->i).average().orElse(0.0);
           System.out.printf("%s: %.2f%n", subject, avg);
      });



    }
}
