package sets.que3;

import java.util.IllegalFormatCodePointException;
import java.util.Objects;

public class Person implements Comparable<Person>{
    int id;
    String name;

    Person(int id , String name){
        this.id=id;
        this.name=name;

    }

    public boolean equals(Object o){
        if(this==o)return true;
        if (!(o instanceof Person))return false;
        Person person=(Person) o;
        return Objects.equals(name,person.name);
    }
    public int compareTo(Person o){
        return Integer.compare(this.id,o.id);
    }

    public int hashCode(){
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }


}
