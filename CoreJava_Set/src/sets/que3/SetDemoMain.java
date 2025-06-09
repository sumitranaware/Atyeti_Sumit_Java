package sets.que3;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemoMain {
    public static void main(String[] args) {
        Person p1 = new Person(1,"Sumit");
        Person p2=new Person(2,"Sumit");

        Set<Person>linkedHashSet=new LinkedHashSet<>();
        linkedHashSet.add(p1);
        linkedHashSet.add(p2);

        System.out.println("Linked Hash Set "+linkedHashSet);

        Set<Person>treeset=new TreeSet<>();
        treeset.add(p1);
        treeset.add(p2);

        System.out.println("Treeset: "+treeset);
    }
}