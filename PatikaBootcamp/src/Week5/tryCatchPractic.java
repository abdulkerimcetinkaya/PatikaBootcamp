package Week5;

import java.util.Scanner;

public class tryCatchPractic {
    public static void main(String[] args) {
        int[] list = new int[]{1,2,3,4,5,6,7,8,9,10};

        Scanner scan = new Scanner(System.in);
        System.out.print("Bir indis numarası giriniz : ");
        int i = scan.nextInt();

        try {
            listElements(list, i);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Hatalı giriş yaptınız.!!!");
        }

    }

    public static void listElements(int[] arr,int index){
        System.out.println("Girilen indisdeki sayı : "+arr[index]);
    }


}
