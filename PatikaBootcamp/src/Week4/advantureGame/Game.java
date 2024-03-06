package Week4.advantureGame;

import java.util.Scanner;
// Bu sınıf oyunun akışını sağlıyor.
public class Game {
    Scanner scan = new Scanner(System.in);
    public void start(){
        System.out.println("Macera Oyununa Hoşgeldiniz !");
        //System.out.print("Lütfen isminizi giriniz : ");
        //String name = scan.nextLine();
        Player player = new Player("Kerim");
        System.out.println(player.getName() + " macera oyununa hoşgeldin!!");
        player.selectChar();

    }

}
