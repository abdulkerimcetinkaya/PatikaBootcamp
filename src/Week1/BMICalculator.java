package Week1;

import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // sdad
        double weight, height, BMI;

        System.out.print("Enter your weight (KG) : ");
        weight = scan.nextDouble();
        System.out.print("Enter your height (M) : ");
        height = scan.nextDouble();

        BMI = weight / (height * height);

        System.out.println("BMI : " + BMI);
    }
}
