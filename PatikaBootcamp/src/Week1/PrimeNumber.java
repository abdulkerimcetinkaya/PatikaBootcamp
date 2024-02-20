package Week1;

public class PrimeNumber {
    public static void main(String[] args) {

        // Printing prime number from 1 to 100

        for (int i = 2; i < 100; i++){
            boolean isPrime = true;
            for (int j = 2; j< (i-1); j++){
                if (i % j == 0){
                    isPrime = false;
                    break;
                }
            }
            if (isPrime){
                System.out.print(i + " ");
            }
        }
    }
}
