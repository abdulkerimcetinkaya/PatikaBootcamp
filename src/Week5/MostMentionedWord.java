package Week5;

import java.util.HashMap;
import java.util.Scanner;

public class MostMentionedWord {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Bir cümle giriniz : ");
        String text = scan.nextLine();
        // text ile alınan cümlenin elemmanlarını boşluktan sonra ayır ve strings dizisine ata
        String[] strings = text.split(" ");

        HashMap<String, Integer> word = new HashMap<>();
        // en sık geçen kelime başlangıçta null değeri ata
        String mostFrequentWord = null;
        // strings dizisinde ki elemanları dön
        for (String s : strings) {
            if (word.containsKey(s)) { // dizinin içinde key(kelime) bulunuyor mu iye kontrol et
                int count = word.get(s);// word array'inin s inci elemanının value sini counta ata
                word.put(s, count + 1); // word dizisinin içine s' i ata ve count'ı 1 artır
            } else { // yok ise s'i word dizisine ata ve count'ı 1 yap
                word.put(s, 1);
            }


            int maxCount = 0; // maxCount 0 olarak ata (en çok geçen ifadeyi bulmak için)
            mostFrequentWord = ""; // en sık geçen kelime boş bir string yap
            // dizinin value değerlerini dön ve en yükseği ekrana yazdır.
            for (String i : word.keySet()) {
                int count = word.get(i);
                if (count > maxCount) {
                    maxCount = count;
                    mostFrequentWord = i;
                }
            }
        }

        System.out.println(word);
        System.out.println("En çok geçen kelime: " + (mostFrequentWord));
    }
}


