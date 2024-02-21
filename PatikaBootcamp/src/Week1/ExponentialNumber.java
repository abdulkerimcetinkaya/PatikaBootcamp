package Week1;

import java.util.Scanner;

public class ExponentialNumber {
    public static void main(String[] args) {
        power(2,3);
        power(5,7);
    }

    public static void power(int base, int exponent){
        int result = 1;

        for (int i = 0; i < exponent;i++){
            result *= base;
        }

        System.out.println("Result : " + result);
    }
}
