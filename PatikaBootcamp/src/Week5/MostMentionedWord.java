package Week5;

import java.util.HashMap;
import java.util.Scanner;

public class MostMentionedWord {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Bir cümle giriniz : ");
        String text = scan.nextLine();

        String[] strings = text.split(" ");

        HashMap<String,Integer> word = new HashMap<>();
        for (String s : strings){
            if (word.containsKey(s)){
                int count = word.get(s);
                word.put(s,count+1);
            }else {
                word.put(s,1);
            }
        }
        System.out.println(word);
        }
    }

