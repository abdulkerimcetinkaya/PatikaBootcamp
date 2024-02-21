package Week1;

public class RecursivePattern {
    public static void main(String[] args) {
        patternMethod(36);
    }


    public static void patternMethod(int number){
        if (number > 0){
            System.out.print(number + " ");
            patternMethod(number - 5);
        }
        System.out.print(number + " ");
    }


}

