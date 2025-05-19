package longest_sub_string;

import java.util.Scanner;

import static longest_sub_string.SubString.uniqueSub;

public class LongestSubString {
    public static void main(String[] args) {
        System.out.println("Enter the string to check the longest substring ");
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();

        int len=uniqueSub(str);
        System.out.println("The length is "+len);
    }
}
