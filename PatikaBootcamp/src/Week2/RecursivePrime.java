package Week2;

import java.util.Scanner;

public class RecursivePrime {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter Number : ");
        int num = input.nextInt();

        System.out.println("Is Prime: "+ isPrime(num, 2));
    }

    public static boolean isPrime(int number, int i) {
        // Check if the given number is less than or equal to 2
        // If the number is equal to 2, return true, otherwise return false
        if (number <= 2){
            return (number == 2) ? true : false;
        }
        // Check if the current divisor (i) divides the number evenly
        // If yes, the number is not prime, so return false
        if (number % i == 0){
            return false;
        }
        // Check if the square of the current divisor (i) is less than the number
        // If yes, continue the prime check recursively with the next divisor (i+1)
        if (i*i < number){
            return true;
        }
        // If none of the above conditions are met, continue the prime check recursively
        // with the next divisor (i+1)
        return isPrime(number , (i + 1));
    }
}

