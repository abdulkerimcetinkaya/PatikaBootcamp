package Week5.BookOrder;

import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        // Kitap isimlerine göre sıralama (Alfabeye göre)
        TreeSet<Book> books = new TreeSet<>(new OrderNameComparable());
        books.add(new Book("Olağanüstü Bir Gece",80,"Stefan Zweig",2017));
        books.add(new Book("Dönüşüm",80,"Franz Kafka",2018));
        books.add(new Book("Cürümenin Kitabı",192,"Emil Michel Cioran",2017));
        books.add(new Book("Kitaplar ve Sigaralar",	64,"George Orwell",1946));
        books.add(new Book("Insanlığımı Yitirirken",128,"Osamu Dazai",2022));

        for(Book b : books){
            System.out.println(b.getName()+ " -> Yazarı : " + b.getAuthorName());
        }

        System.out.println("-------------------------");

        // Kitapları sayfa sayısına göre sıralama (Küçükten, büyüğe)
        TreeSet<Book> book = new TreeSet<>(new OrderPageNumberComparable());
        book.add(new Book("Olağanüstü Bir Gece",90,"Stefan Zweig",2017));
        book.add(new Book("Dönüşüm",80,"Franz Kafka",2018));
        book.add(new Book("Cürümenin Kitabı",192,"Emil Michel Cioran",2017));
        book.add(new Book("Kitaplar ve Sigaralar",	64,"George Orwell",1946));
        book.add(new Book("Insanlığımı Yitirirken",128,"Osamu Dazai",2022));

        for(Book b2 : book){
            System.out.println(b2.getName()+ " -> sayfa sayısı : " +b2.getPageNumber());
        }


    }
}
