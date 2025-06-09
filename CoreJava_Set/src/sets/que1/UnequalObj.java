package sets.que1;

import java.util.HashSet;
import java.util.Set;

/***
 What happens when two unequal objects have the same hashCode in a HashSet?
 Behavioral Insight:
 HashSet uses hashCode() to locate bucket and equals() to check equality.
 Problem:
 Create three objects with same hashCode but different equals(). Add both to a HashSet and observe whether both are added or not.
 */
public class UnequalObj {
    public static void main(String[] args) {
        Set<Student>students=new HashSet<>();

        Student s1=new Student(1,"Sumit");
        Student s2=new Student(2,"Shubham");
        Student s3=new Student(3,"Rohit");

        students.add(s1);
        students.add(s2);
        students.add(s3);

        System.out.println("Set size "+ students.size());
        System.out.println("Contents ");
        for (Student s:students){
            System.out.println(s);
        }

    }
}
