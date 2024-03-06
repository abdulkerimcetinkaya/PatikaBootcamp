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

        Location location = null;
        while (true){
            System.out.print("------------------BÖLGELER------------------\n1 - Güvenli Ev\n2 - Mağaza\nLütfen gitmek istediğiniz bölgeyi seçiniz : ");
            int selectLoc = scan.nextInt();
            switch (selectLoc){
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                default:
                    location = new SafeHouse(player);
            }

            if(!location.onLocation()){
                System.out.println("GAME OVER");
                break;
            }
        }

    }

}
