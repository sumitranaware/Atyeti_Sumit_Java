package employee_analytics_dashboard.service;

import employee_analytics_dashboard.entity.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeService {
    List<Employee>employeeList=new ArrayList<>();
    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
    public void addEmployee(Employee employee){
    boolean exists=employeeList.stream()
            .anyMatch(p->p.getId()==employee.getId());
    if(exists){
        System.out.println("Employee with same id already exists");
    }
    else {
        employeeList.add(employee);

    }

    }
   public Double groupByDepartment(String department){
       Map<String, Double>avgSalByDep=employeeList.stream()
               .collect(Collectors.groupingBy(Employee::getDepartment,
                       Collectors.averagingDouble(Employee::getSalary)));
       return avgSalByDep.getOrDefault(department,0.0);
   }
      public String cityWithHighestNoEmp(){
        return employeeList.stream()
                .collect(Collectors.groupingBy(
                        Employee::getCity,Collectors.counting()
                ))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("No Employee is available");
      }

      public List<Employee> getEmployeeOlderThan40(){
        return employeeList.stream()
                .filter(employee -> employee.getAge()>40)
                .toList();
      }

}
