package stream_api.que7;

import stream_api.que7.model.Employee;
import stream_api.que7.service.EmployeeService;

import java.util.List;

public class DashboardMain {
    public static void main(String[] args) {
        List<Employee>employees=List.of(
                new Employee("Sumit","Tech",5,true,List.of("Java","Spring","Docker")),
                new Employee("Akash","HR",4,true,List.of("Recruitment","Leaves")),
                new Employee("Shreeraj","IT",5,false,List.of("Complainace","Access")),
                new Employee("Raj","Fianance",4,true,List.of("Accounting","TimeSheet")),
                new Employee("Indrajeet","Tech",4,false,List.of("Python","Django"))
        );

        EmployeeService employeeService=new EmployeeService();
        System.out.println("Grouped ny department");
        System.out.println(employeeService.groupByDepartment(employees));

        System.out.println("Partitioned active/ inactive");
        System.out.println(employeeService.partitionActiveByDepartment(employees));

        System.out.println("Skills per department");
        System.out.println(employeeService.skillsPerDepartment(employees));

        System.out.println("Average rating per department ");
        System.out.println(employeeService.averageRatingByDepartment(employees));

        System.out.println("Active employee summary");
        System.out.println(employeeService.activeEmployeeSummary(employees));
    }
}
