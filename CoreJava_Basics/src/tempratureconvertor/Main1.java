package tempratureconvertor;

import java.util.Scanner;

import static tempratureconvertor.Temp_Convertor.*;

public class Main1 {
    public static void main(String[] args) {

        System.out.println("Enter 1 for Celcius to Fahrenheit\n Enter 2 for Celcius to Kelvin\n" +
                "        Enter 3 for Fahrenheit to Celcius\n Enter 4 for Fahrenheit to Kelvin\n" +
                "         Enter 5 for Kelvin to Celcius\n Enter 6 for Kelvin to Fahrenheit\n 7. Exit\"");

    do{
        System.out.println("Enter your temperature choice number ");
        int tempraturechoice=sc.nextInt();
        double choicenumber=0;
        switch (tempraturechoice){
            case 1:
             inputtemperature("celcius");
             outputtemperature(celciusToFahrenheit(choicenumber),"Fahrenheit");
             break;

            case 2:
                inputtemperature("celcius");
                outputtemperature(celciusToKelvin(choicenumber),"kelvin");
                break;
            case 3:
                inputtemperature("fahrenheit");
                outputtemperature(fahrenheitToCelcius(choicenumber),"celcius");
                break;

            case 4:
                inputtemperature("fahrenheit");
                outputtemperature(farhrenheitToKelvin(choicenumber),"kelvin");
                break;

            case 5:
                inputtemperature("kelvin");
                outputtemperature(kelvinToCelcius(choicenumber),"kelvin");
                break;
            case 6:
                inputtemperature("kelvin");
                outputtemperature(kelvinToFahrenheit(choicenumber),"kelvin");
                break;
            case 7:
                System.exit(0);
            default:
                System.out.println("Enter the valid choice");
        }

    }
while (true);



    }
}
