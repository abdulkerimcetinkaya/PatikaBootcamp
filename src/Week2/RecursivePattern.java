package Week2;

import java.util.Scanner;

public class RecursivePattern {
    public static void main(String[] args) {
        Scanner input  = new Scanner(System.in);

        System.out.print("Enter Number : ");
        int num = input.nextInt();

        patternMethod(num);
    }


    public static void patternMethod(int number){
        if (number > 0){
            System.out.print(number + " ");
            patternMethod(number - 5);
        }
        System.out.print(number + " ");
    }


}

