package studentgradechecker;

import java.util.Scanner;

/***
 Student Grade Checker

 Input marks of a student

 Use if-else to determine grade (A, B, C, D, F)

 Print fail if minimum marks
 */

public class StudentGradeChecker {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the student marks to check grade");
        int marks=sc.nextInt();
        if(marks>90){
            System.out.println("Grade is A");
        }
        else if(marks>80 && marks<90){
            System.out.println("Grade is B");
        }
        else if(marks>70 && marks<80){
            System.out.println("Grade is C");
        }
     else if (marks>60 && marks<70){
            System.out.println("Grade is D");
        }
       else if(marks>50 && marks<60){
            System.out.println("Grade is E");
        }
        else {
            System.out.println("Student is fail");
        }
    }
}
