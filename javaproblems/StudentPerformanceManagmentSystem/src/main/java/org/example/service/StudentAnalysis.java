package org.example.service;

import org.example.entity.Student;
import org.example.repository.StudentRepository;
import org.example.utility.LoggerUtil;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StudentAnalysis {
    public static List<Student>studentList;

    public StudentAnalysis(){
        StudentRepository studentRepository = new StudentRepository();
        studentList= studentRepository.loadStudents();
        if(studentList==null||studentList.isEmpty()){
            System.out.println("No Students found in Student.json");
            LoggerUtil.logWarning("No Students found in json");
        }
    }
    public List<Student>getTop3Student(List<Student>students){
        return studentList.stream()
                .sorted((s1,s2)->Double.compare(getStudentAverage(s2.getMarks()),
                        getStudentAverage(s1.getMarks())
                        ))
                        .limit(3)
                        .collect(Collectors.toList());

    }

    public double getStudentAverage(List<Integer> marks){
        return marks.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);

    }
    public void failedStudent(int marks){
        studentList.stream()
                .filter(s->getStudentAverage(s.getMarks())<40)
                .collect(Collectors.toList());
    }
    public List<Student> sortStudentByName(List<Student>students){
        return students.stream()
                .sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toList());
    }
}
