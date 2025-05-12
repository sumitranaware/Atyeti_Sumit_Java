package org.example.repository;

import org.example.entity.Student;
import org.example.utility.JsonFileHandler;

import java.security.PublicKey;
import java.util.List;

public class StudentRepository {
    private static final String STUDENT_FILE="C:\\Users\\SumitRanaware\\OneDrive - Atyeti Inc\\Desktop\\Atyeti_Sumit_Java\\javaproblems\\StudentPerformanceManagmentSystem\\src\\main\\java\\org\\example\\database\\studentinput.json";

    public List<Student>loadStudents(){
        return JsonFileHandler.readFromJsonFile(STUDENT_FILE,Student.class);
    }
    public void saveStudents(List<Student>students){
        JsonFileHandler.writeToJsonFile(STUDENT_FILE,students);
        System.out.println("Student saved Successfully");
    }
}
