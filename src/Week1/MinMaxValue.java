package Week1;

import java.util.Scanner;

public class MinMaxValue {
    public static void main(String[] args) {

        // Scanner object defined
        Scanner input = new Scanner(System.in);

        // // We defined the min and max variables and initially assigned them the value 0.
        int max = 0;
        int min = 0;

        // We received information from the user about how many numbers they will enter.
        System.out.print("How many numbers will you enter? : ");
        int number = input.nextInt();

        // Our loop will run until the number variable entered by the user is less than or equal to the number.
        for (int i = 1; i <= number;i++){
            System.out.print("Number " + i + " : ");
            int inputNumber = input.nextInt();

            // if the number is greater than the max value.
            if (inputNumber > max){
                max = inputNumber;
            }
            // if the number is less than the min value or we made sure the loop started
            if (inputNumber < min || i == 1) {
                min = inputNumber;
            }
        }
        System.out.println("largest number : " + max);
        System.out.println("smallest number : " + min);
    }
}
