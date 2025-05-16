import employeepayrolesystem.ContractEmployee;
import employeepayrolesystem.Employee;
import employeepayrolesystem.FullTimeEmployee;
import employeepayrolesystem.PartTimeEmployee;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee>employees=new ArrayList<>();
        employees.add(new FullTimeEmployee(102,"Sumit",10000,5000));
        employees.add(new PartTimeEmployee(103,"Shreeraj",10000,45,500));
        employees.add(new ContractEmployee(104,"Raj",5000,6));
        employees.add(new FullTimeEmployee(105,"Shubham",50000,5000));

        for(Employee e1:employees){
            System.out.println( e1.calculateSal());
        }



    }
}