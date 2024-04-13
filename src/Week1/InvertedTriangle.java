package Week1;

import java.util.Scanner;

public class InvertedTriangle {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        System.out.print("Basamak sayısı giriniz : ");
        int num = input.nextInt();

        for (int i = num; i >= 0; i--){
          for (int j = 0; j < num ; j++){
              System.out.print(" *");
          }
            System.out.println();
          num--;
        }


    }
}
