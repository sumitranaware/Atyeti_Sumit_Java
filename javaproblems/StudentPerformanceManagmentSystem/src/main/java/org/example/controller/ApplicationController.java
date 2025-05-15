package org.example.controller;

import org.example.entity.Student;

import java.util.List;

public interface ApplicationController {
    void startApplication();
    void displayMenu();
    void addStudent();
    void removeStudent();
    void updateStudent();
    void getAllStudent();
    void getStudentById(int id);

    void getTop3Student(List<Student> allStudents);

    void getAverage();
    void failedStudent();
    void sortStudentByName();
}
