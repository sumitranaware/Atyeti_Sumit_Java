package cli_calculator;

import java.util.Scanner;

/***CLI Calculator
 Create a command-line calculator that:
 Takes two numbers and an operator (+, -, *, /)
 Performs the operation
 Repeats until user chooses to exit***/

public class CliCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continueCal = true;

        while (continueCal) {
            System.out.println("Enter the First number");
            double number1 = sc.nextDouble();
            System.out.println("Enter the Second number");
            double number2 = sc.nextDouble();
            System.out.println("Choose Operation(+,-,*,/,%)");
            char choice = sc.next().charAt(0);
            double result = 0;
            boolean valid = true;
            switch (choice) {
                case '+':
                    result = number1 + number2;
                    break;
                case '-':
                    result = number1 - number2;
                    break;
                case '*':
                    result = number1 * number2;
                    break;
                case '/':
                    if (number2 != 0) {
                        result = number1 / number2;
                    } else {
                        System.out.println("Number should be greater than 0");

                    }
                    break;
                case '%':
                    if (number2 != 0) {
                        result = number1 % number2;
                    } else {
                        System.out.println("Number should be greater than 0");
                    }
                    break;
                default:
                    System.out.println("Please select the valid operator ");
                    valid = false;
            }
            if (valid) {
                System.out.println("result " + result);

                System.out.println("Do you want to continue? (yes/no)");
                String select=sc.next();
                if(!select.equalsIgnoreCase("yes"));
                continueCal=false;
                System.out.println("Thank for using the calculator");
            }
        }
        sc.close();
    }
}

