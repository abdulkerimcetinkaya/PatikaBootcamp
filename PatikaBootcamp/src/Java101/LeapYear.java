package Java101;

import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a year: ");
        int year = input.nextInt();

        String leapYear = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) ? "is a leap year." : "isn't a leap year.";
        System.out.println(year + " " + leapYear);


    }
}
