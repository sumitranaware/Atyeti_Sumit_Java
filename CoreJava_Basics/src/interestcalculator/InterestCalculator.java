package interestcalculator;

import java.util.Scanner;

public class InterestCalculator {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Principle Amount");
        int principle=sc.nextInt();
        System.out.println("Enter the Rate");
        int rate=sc.nextInt();
        System.out.println("Enter the Month");
        int time=sc.nextInt();

        double interest= (double) (principle * rate * time) /100;

        System.out.println("Interest is : "+interest);
    }
}
