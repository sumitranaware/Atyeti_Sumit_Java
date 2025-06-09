package sets.que1;

import java.util.Objects;

public class Student {
    private int id;
    private String name ;

    public Student(int id , String name){
        this.id=id;
        this.name=name;
    }
    public int hashCode(){
        return 42;
    }

    public boolean equals(Object obj){
        if (this==obj)return true;
        if (!(obj instanceof Student))return false;
        Student other=(Student) obj;

        return this.id==other.id&& Objects.equals(this.name, other.name);


    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }



}
