package Week1;

import java.util.Scanner;

public class Casting {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Please enter an integer (int): ");
        int numInt = input.nextInt();

        System.out.print("Please enter a decimal number (double): ");
        double numDouble = input.nextDouble();

        double castingIntToDouble = numInt;
        int castingDoubleToInt = (int) numDouble;

        System.out.println(castingIntToDouble + " number converted from integer to double");
        System.out.println(castingDoubleToInt + " number converted from double to integer");
    }
}
