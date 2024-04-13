package Week1;

import java.util.Scanner;

public class PerfectNumber {
    public static void main(String[] args) {

        // Scanner class created
        Scanner input = new Scanner(System.in);

        // The total variable was created.
        int total = 0;

        // The num value was received from the user.
        System.out.print("Enter number: ");
        int num = input.nextInt();

        // The value of i started at 1 and was increased by 1 in each cycle until the value of num.
        for (int i = 1; i < num; i ++){
            // if the remainder of dividing num by i is 0
            if (num % i == 0){
                total += i;
            }
        }

        // If num value is equal to total value
        if (num == total){
            System.out.println(num + " is a perfect number.");
        }else {
            System.out.println(num + " is not a perfect number.");
        }

    }
}
