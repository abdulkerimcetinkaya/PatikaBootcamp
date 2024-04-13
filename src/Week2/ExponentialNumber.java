package Week2;

import java.util.Scanner;

public class ExponentialNumber {
    public static void main(String[] args) {

        // Scanner sınıfı tanımlandı
        Scanner input = new Scanner(System.in);

        // kullanıcıdan taban sayısını al
        System.out.print("Enter base number : ");
        int num1 = input.nextInt();

        // kullanıcıdan üs sayısını al
        System.out.print("Enter exponental number : ");
        int num2 = input.nextInt();
        // sonucu ekrana yazdır
        System.out.println("Result : " + power(num1,num2));

    }

    public static int power(int base, int exponent){
        // If the exponent is equal to 0, return 1,
        // otherwise compute the power recursively.
        if (exponent == 0){
            // Base case: if the exponent is 0, return 1
            return 1;
        } else {
            // Recursive case: compute the power by multiplying the base
            // with the result of recursively computing the power with
            // a decremented exponent.
            int result = base * power(base, exponent - 1);
            return result;
        }
    }

}
