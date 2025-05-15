package org.example.controller;

import org.example.entity.Student;
import org.example.exception.InvalidInputException;
import org.example.exception.StudentNotFoundException;
import org.example.service.StudentAnalysis;
import org.example.service.StudentService;
import org.example.utility.LoggerUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ApplicationControllerImpl implements ApplicationController {
    private final Scanner sc = new Scanner(System.in);
    private final StudentService studentService = new StudentService();
    private final StudentAnalysis studentAnalysis = new StudentAnalysis();



    @Override
    public void startApplication() {
        while (true) {
            displayMenu();
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> removeStudent();
                case 3 -> updateStudent();
                case 4 -> getAllStudent();
                case 5 -> {
                    System.out.println("Enter the id:");
                    int id=sc.nextInt();
                    sc.nextLine();
                    getStudentById(id);
                }
                case 6 -> {
                    List<Student> allStudents = studentService.getAllStudent();
                    getTop3Student(allStudents);
                }
                case 7 -> getAverage();
                case 8 -> failedStudent();
                case 9 -> sortStudentByName();
                case 10 -> exitApplication();
                default -> System.out.println("Invalid choice try again");
            }
        }
    }

    @Override
    public void displayMenu() {
        System.out.println("Student Performance Management System....");
        System.out.println("1. Add Student");
        System.out.println("2. Remove Student ");
        System.out.println("3. Update Student ");
        System.out.println("4. Get All Student ");
        System.out.println("5. Get Student By Id");
        System.out.println("6. Get Top 3 Student ");
        System.out.println("7. Get Average");
        System.out.println("8. Failed Student");
        System.out.println("9. Sort Student By Name ");
        System.out.println("10. Exit application");
    }

    @Override
    public void addStudent() {
        System.out.println("Enter Student id");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the Student name");
        String name = sc.nextLine();
        System.out.println("Enter the mail id");
        String email = sc.nextLine();
        System.out.println("Enter the course name");
        String course = sc.nextLine();
        System.out.println("Enter the marks");
        String[] input = sc.nextLine().trim().split("\\s+");
        List<Integer> marks = new ArrayList<>();
        for (String s : input) {
            try {
                marks.add(Integer.parseInt(s));
            } catch (InvalidInputException e) {
                System.out.println("Invalid input: " + s + " is not a number.");
                LoggerUtil.logWarning("Invalid input: " + s + " is not a number.");
            }
        }
        sc.nextLine();
        Student student = new Student(id, name, email, course, marks);
        studentService.addStudent(student);
    }

    @Override
    public void removeStudent() {
        System.out.println("Enter the Student id to be remove");
        int id = sc.nextInt();
        try {
            studentService.removeStudent(id);
            System.out.println("Student removed successfully  ");
            LoggerUtil.logInfo("Student removed successfully");
        } catch (StudentNotFoundException e) {
            System.out.println("Student not Found ");
            LoggerUtil.logWarning("Student not Found");
        }
    }

    @Override
    public void updateStudent() {
        System.out.println("Enter the student id to update");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter the New Student name");
        String name = sc.nextLine();

        System.out.println("Enter the Student email");
        String email = sc.nextLine();

        System.out.println("Enter the course name");
        String course = sc.nextLine();

        System.out.println("Enter the marks");
        String[] input = sc.nextLine().trim().split("\\s+");
        List<Integer> marks = new ArrayList<>();
        for (String s : input) {
            try {
                marks.add(Integer.parseInt(s));
            } catch (InvalidInputException e) {
                System.out.println("Invalid input: " + s + " is not a number.");
                LoggerUtil.logWarning("Invalid input: " + s + " is not a number.");
            }
        }
        sc.nextLine();

        Student updatestudent = new Student(id, name, email, course,marks);
        try {
            studentService.updateStudent(updatestudent);
            StudentService.studentList.add(updatestudent);
            System.out.println("Student updated successfully");
            LoggerUtil.logInfo("Student updated successfully");
        } catch (StudentNotFoundException e) {
            System.out.println("Student not found");
            LoggerUtil.logWarning("Student not found");
        }
    }

    @Override
    public void getAllStudent() {
        List<Student> students = studentService.getAllStudent();
        if (students.isEmpty()) {
            System.out.println("Student is Empty");
            LoggerUtil.logWarning("Student is Empty");
        } else {
            System.out.println("Student list");
            LoggerUtil.logInfo("Student list");
            for (Student s1 : students) {
                System.out.println(s1.toString());
            }
        }
    }

    @Override
    public void getStudentById(int id) {
      Student student=null;
      try{
          student=studentService.getStudentById(id);

      } catch (StudentNotFoundException e) {
          System.out.println("Student not found");
      } catch (InvalidInputException e) {
          System.out.println("Invalid ID: " + e.getMessage());
      }
          if (student != null) {
              System.out.println("Student found" + student);
              LoggerUtil.logInfo("Student Found" + student);

          }

//      else {
//          System.out.println("Student not found");
//          LoggerUtil.logWarning("Student not found");
//      }
    }

    @Override
    public void getTop3Student(List<Student> allStudents) {
        List<Student> topStudents = studentAnalysis.getTop3Student(allStudents);
        topStudents.forEach(System.out::println);
    }


    @Override
    public void getAverage() {
        List<Student> students=studentService.getAllStudent() ;
        if(students.isEmpty()){
            System.out.println("No Student is available");
            LoggerUtil.logWarning("No Student is Available");
        }
        for (Student s1 : students){
            List<Integer>marks=s1.getMarks();
            if(marks==null||marks.isEmpty()) {
                System.out.println("No marks available for student " + s1.getName());
                LoggerUtil.logWarning("No marks available for student " + s1.getName());

            }
            double average= studentAnalysis.getStudentAverage(marks);
            System.out.println("Average marks of "+ s1.getName()+" is "+average);
            LoggerUtil.logInfo("Average marks of "+ s1.getName()+" is "+average);
        }
    }

    @Override
    public void failedStudent() {
        List<Student> students=studentService.getAllStudent() ;
        if(students.isEmpty()){
            System.out.println("No Student is available");
            LoggerUtil.logWarning("No Student is available");
        }
        boolean anyFailed = false;
        for (Student s : students) {
            List<Integer> marks = s.getMarks();
            double average = studentAnalysis.getStudentAverage(marks);
            if (average < 40) {
                System.out.println("Name: " + s.getName() + ", Average: " + average);
                LoggerUtil.logInfo("Name: " + s.getName() + ", Average: " + average);
                anyFailed = true;
            }
        }

        if (!anyFailed) {
            System.out.println("No failed students found.");
            LoggerUtil.logInfo("No failed student found");
        }
    }

    @Override
    public void sortStudentByName() {
    List<Student>allStudent=studentService.getAllStudent();
        if (allStudent.isEmpty()) {
            System.out.println("Student is Empty");
            LoggerUtil.logWarning("Student is empty");
        }
            List<Student>sortedStudent=studentAnalysis.sortStudentByName(allStudent);
            for (Student s:sortedStudent){
                System.out.println(s.toString());
            }

    }

    public void exitApplication() {
        System.out.println("Thank you for using Student Performance Management System");
        LoggerUtil.logInfo("Thank you for using Student Performance Management System");
   System.exit(0);

    }
}
