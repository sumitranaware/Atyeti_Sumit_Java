package ArrayList.que7;

import java.util.ArrayList;
import java.util.List;

public class ObjReference {
    public static void main(String[] args) {
        Person p1 = new Person("Sumit",23);

        List<Person> people=new ArrayList<>();
        people.add(p1);
        people.add(p1);
        people.add(p1);

        System.out.println("Before Modification");
        people.forEach(System.out::println);

        p1.age=24;
        p1.name="Sumit Ranaware";

        System.out.println("\n after modification");
        people.forEach(System.out::println);
    }

}