package Week5.BookOrder;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("1 -> Kitap Adına Göre Dizilim (Alfabetik Sıra)");
        System.out.println("2 -> Sayfa Sayısına Göre Dizilim (Küçükten Büyüğe)");
        System.out.println("Bir seçim yapınız : ");
        int chosse = scan.nextInt();

        switch (chosse){
            case 1:
                System.out.println("Kitapları isimlere göre sıralaması");
                System.out.println("-----------------------------------");
                toPageNumber();
                break;
            case 2:
                System.out.println("Sayfa Sayısına Göre Dizilim (Küçükten Büyüğe)");
                System.out.println("-----------------------------------");
                toName();
                break;
            default:
                System.out.println("Geçerli sayı giriniz : ");
        }
    }

    public static void toName(){
        // Kitap isimlerine göre sıralama (Alfabeye göre)
        TreeSet<Book> orderBookName = new TreeSet<>(new OrderNameComparable());
        orderBookName.add(new Book("Olağanüstü Bir Gece",80,"Stefan Zweig",2017));
        orderBookName.add(new Book("Dönüşüm",80,"Franz Kafka",2018));
        orderBookName.add(new Book("Cürümenin Kitabı",192,"Emil Michel Cioran",2017));
        orderBookName.add(new Book("Kitaplar ve Sigaralar",	64,"George Orwell",1946));
        orderBookName.add(new Book("Insanlığımı Yitirirken",128,"Osamu Dazai",2022));

        for(Book b : orderBookName){
            System.out.println(b.getName()+ " -> Yazarı : " + b.getAuthorName());
        }
    }

    public static void toPageNumber(){
        // Kitapları sayfa sayısına göre sıralama (Küçükten, büyüğe)
        TreeSet<Book> orderPageNumber = new TreeSet<>(new OrderPageNumberComparable());
        orderPageNumber.add(new Book("Olağanüstü Bir Gece",90,"Stefan Zweig",2017));
        orderPageNumber.add(new Book("Dönüşüm",80,"Franz Kafka",2018));
        orderPageNumber.add(new Book("Cürümenin Kitabı",192,"Emil Michel Cioran",2017));
        orderPageNumber.add(new Book("Kitaplar ve Sigaralar",	64,"George Orwell",1946));
        orderPageNumber.add(new Book("Insanlığımı Yitirirken",128,"Osamu Dazai",2022));

        for(Book b2 : orderPageNumber){
            System.out.println(b2.getName()+ " -> sayfa sayısı : " +b2.getPageNumber());
        }
    }
}
