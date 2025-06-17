package stream_api.que7.service;

import stream_api.que7.model.Employee;

import javax.swing.plaf.PanelUI;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class EmployeeService {
    public Map<String, List<Employee>>groupByDepartment(List<Employee>employees){
        return employees.stream()
                .collect(groupingBy(Employee::getDepartment));
    }
    public Map<String,Map<Boolean ,List<String>>>partitionActiveByDepartment(List<Employee>employees){
        return employees.stream()
                .collect(groupingBy(Employee::getDepartment,partitioningBy(Employee::isActive,
                        mapping(Employee::getName,toList())
                        )));
    }
    public Map<String, Set<String>>skillsPerDepartment(List<Employee>employees){
        return employees.stream()
                .collect(groupingBy(Employee::getDepartment
                        ,flatMapping(e->e.getSkills().stream(),toSet())));
    }
    public Map<String,Integer>skillsFrequency(List<Employee>employees){
        return employees.stream()
                .flatMap(e->e.getSkills().stream().distinct())
                .collect(toMap(Function.identity(),s->1,Integer::sum));

    }
    public Map<String,Double>averageRatingByDepartment(List<Employee>employees){
        return employees.stream()
                .collect(groupingBy(Employee::getDepartment,
                        averagingInt(Employee::getRating)
                        ));
    }
    public String activeEmployeeSummary(List<Employee>employees){
        return employees.stream()
                .filter(Employee::isActive)
                .map(Employee::getName)
                .collect(Collector.of(
                        StringBuilder::new,
                        (sb,name)->{
                            if (sb.length()>0) sb.append(", ");
                            sb.append(name);
                        },
                        StringBuilder::append,
                        StringBuilder::toString
                ));
    }

}
