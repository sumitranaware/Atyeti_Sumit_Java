package neststed_collections.que1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/***
 1. Map<String, List<String>> — Grouping
 Insight: Useful for grouping data like department → employees
 Problem:
 Add multiple employees under different departments. Then:
 Print all employees in each department.
 Add a new employee to an existing department using computeIfAbsent()
 */
public class EmployeeDepartment {
    public static void main(String[] args) {
        Map<String, List<String>>deptMap=new HashMap<>();
        deptMap.computeIfAbsent("HR",dep->new ArrayList<>()).add("Rohit");
        deptMap.computeIfAbsent("HR",dep->new ArrayList<>()).add("Raj");

        deptMap.computeIfAbsent("Tech",dept->new ArrayList<>()).add("Sumit");
        deptMap.computeIfAbsent("Tech",dep->new ArrayList<>()).add("Shubham");

        deptMap.computeIfAbsent("Fianance",dep->new ArrayList<>()).add("Shreeraj");

        System.out.println("Employees by department");
        for (Map.Entry<String,List<String>>entry:deptMap.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
        deptMap.computeIfAbsent("Tech",dept->new ArrayList<>()).add("Pranav");
        System.out.println("After adding another Employee");
        System.out.println("Tech "+deptMap.get("Tech"));


    }
}
