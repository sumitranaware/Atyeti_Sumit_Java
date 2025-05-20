package student_grade_checker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentMain {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Sumit", 85),
                new Student("Shubham", 76),
                new Student("Sumit", 90),
                new Student("Sumit", 78),
                new Student("Shubham", 88)
        );

        Map<String, List<Integer>> listMap = new HashMap<>();
        for (Student s : students) {
            listMap.computeIfAbsent(s.getName(), k -> new ArrayList<>()).add(s.getMarks());
        }


        for (Map.Entry<String, List<Integer>> i : listMap.entrySet()) {
            String name =i.getKey();
            List<Integer>marks=i.getValue();

            double avg=marks.stream().mapToInt(Integer::intValue).average().orElse(0.0);
            System.out.println(name+" "+marks+"  "+avg);

        }
    }
}