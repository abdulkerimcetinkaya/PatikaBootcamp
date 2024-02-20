package Week1;

import java.util.Scanner;
public class ProcessPriority {
    public static void main(String[] args) {
        // Scanner class create.
        Scanner input = new Scanner(System.in);

        // n1,n2,n3 variables are defined
        double n1,n2,n3,result;

        // Users input
        System.out.print("enter the number n1 : ");
        n1 = input.nextDouble();
        System.out.print("enter the number n2 : ");
        n2 = input.nextDouble();
        System.out.print("enter the number n3 : ");
        n3 = input.nextDouble();

        // Assigning the operation to the result variable
        result = n1+n2*n3-n2;

        // Printing the result to the screen
        System.out.println("Result : " + result);


    }
}