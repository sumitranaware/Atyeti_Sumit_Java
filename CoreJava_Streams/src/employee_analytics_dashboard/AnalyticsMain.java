package employee_analytics_dashboard;

import employee_analytics_dashboard.entity.Employee;
import employee_analytics_dashboard.service.EmployeeService;

import java.util.List;

public class AnalyticsMain {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee(1,"Sumit", "IT", "Pune", 75000, 28),
                new Employee(2,"Shubham", "Finance", "Mumbai", 65000, 32),
                new Employee(3,"Rohit", "IT", "Pune", 82000, 35),
                new Employee(4,"Shreeraj","QA","Pune",4456565,43)
        );

        EmployeeService employeeService=new EmployeeService();
        employeeService.setEmployeeList(employees);
        System.out.println(employeeService.groupByDepartment("IT"));

        System.out.println(employeeService.cityWithHighestNoEmp());

        System.out.println(employeeService.getEmployeeOlderThan40());


    }




}
