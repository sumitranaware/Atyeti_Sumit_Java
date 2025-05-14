package org.example.service;

import org.example.entity.Student;
import org.example.exception.InvalidInputException;
import org.example.exception.StudentNotFoundException;
import org.example.repository.StudentRepository;

import java.util.List;

public class StudentService {
    public static List<Student>studentList;
    private final StudentRepository studentRepository=new StudentRepository();

    public StudentService(){
        studentList=studentRepository.loadStudents();
        if(studentList==null||studentList.isEmpty()){
            System.out.println("No Students found in json");
        }
    }
    public void addStudent(Student student){
        boolean exists=studentList.stream()
                .anyMatch(s->s.getId()==student.getId());

        if(exists){
            System.out.println("Student with same id is already exists");
        }
        else {
            studentList.add(student);
            studentRepository.saveStudents(studentList);
        }
    }

    public void removeStudent(int id){
        studentList.removeIf(s->s.getId()==id);
        studentRepository.saveStudents(studentList);

    }
public void updateStudent(Student updateStudent){
        for(int i=0;i<studentList.size();i++){
            if(studentList.get(i).getId()==updateStudent.getId()){
                studentList.set(i,updateStudent);
                break;
            }
        }
        studentRepository.saveStudents(studentList);
}
    public List<Student>getAllStudent(){
        studentList=studentRepository.loadStudents();
        return studentList;
    }
    public Student getStudentById(int id){
        return studentList
                .stream()
                .filter(s->s.getId()==id)
                .findFirst().orElseThrow(()->new StudentNotFoundException("Student not found "));
    }



}
