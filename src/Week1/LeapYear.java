package Week1;

import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {

        // As a general rule, leap years are years that are multiples of the number 4.
        // Among the years that are multiples of 100, only those that are divisible by 400 without remainder are leap years.

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a year: ");
        int year = input.nextInt();

        String leapYear = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) ? "is a leap year." : "isn't a leap year.";


        System.out.println(year + " " + leapYear);


    }
}
