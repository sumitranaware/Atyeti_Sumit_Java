package tempratureconvertor;

import java.util.Scanner;

public class Temp_Convertor {
    static Scanner sc=new Scanner(System.in);

    static double celciusToFahrenheit(double celcius){
        return (celcius*9/5)+32;
    }
    static double celciusToKelvin(double celcius){
        return (celcius+273.15);
    }
    static double fahrenheitToCelcius(double fahrenheit){
        return (fahrenheit-32)*5/9;
    }
    static double farhrenheitToKelvin(double fahrenheit){
        return (fahrenheit-32)*5/9+273.15;
    }
    static double kelvinToCelcius(double kelvin){
        return(kelvin-273.5);
    }
    static double kelvinToFahrenheit(double kelvin){
        return(kelvin-273.15)*9/5+32;
    }
    static double inputtemperature(String temperature){
        System.out.println("Enter the temperature"+temperature);
        double val=sc.nextDouble();
        return val;
    }
    static void outputtemperature(double value, String temperature){
        System.out.println("Enter the temperature"+temperature+" value is "+value);
    }

}
