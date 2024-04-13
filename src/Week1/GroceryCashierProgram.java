package Week1;

import java.util.Scanner;

public class GroceryCashierProgram {
    public static void main(String[] args) {
        // Creating a Scanner object.
        Scanner input = new Scanner(System.in);

        // Price information of the products is assigned to variables.
        double armutPrice = 2.17;
        double elmaPrice = 3.67;
        double domatesPrice = 1.11;
        double muzPrice = 0.95;
        double patlicanPrice = 5.00;

        // User input
        System.out.print("How many kilograms of Armut did you buy? : ");
        int armutKilos = input.nextInt();

        System.out.print("How many kilograms of Elma did you buy? : ");
        int elmaKilos = input.nextInt();

        System.out.print("How many kilograms of Domates did you buy? : ");
        int domatesKilos = input.nextInt();

        System.out.print("How many kilograms of Muz did you buy? : ");
        int muzKilos = input.nextInt();

        System.out.print("How many kilograms of Patlıcan did you buy? : ");
        int patlicanKilos = input.nextInt();

        // Calculating prices with the entered kilo quantities.
        double totalPrice =
                (armutKilos * armutPrice) +
                        (elmaKilos * elmaPrice) +
                        (domatesKilos * domatesPrice) +
                        (muzKilos * muzPrice) +
                        (patlicanKilos * patlicanPrice);


        // Printing to the screen.
        System.out.println("Total price of the products in your basket : " + totalPrice + " TL");
    }
}
