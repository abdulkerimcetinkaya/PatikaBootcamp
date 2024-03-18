package Week5;

public class tryCatchPractic {
    public static void main(String[] args) {
        int[] list = new int[]{1,2,3,4,5,6,7,8,9,10};

        try {
            listElements(list, 2);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Hatalı giriş yaptınız.!!!");
        }

    }

    public static void listElements(int[] arr,int index){
        System.out.println(arr[index]);
    }


}
