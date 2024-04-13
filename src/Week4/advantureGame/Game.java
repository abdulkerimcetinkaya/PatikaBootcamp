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
            player.printInfo();
            System.out.println();
            System.out.print("------------------BÖLGELER------------------\n" +
                    "1 - Güvenli Ev -> Burası sakin...\n" +
                    "2 - Dükkan -> Yeni zırh ve silahlar geldi.\n" +
                    "3 - Mağara -> Ödül <YEMEK> dikkatli ol karşına zombi çıkabilir..\n"+
                    "4 - Orman -> Ödül <ODUN> dikkatli ol karşına vampir çıkabilir..\n"+
                    "5 - Nehir -> Ödül <SU> dikkatli ol karşına ayı çıkabilir..\n"+
                    "6 - Maden -> Ödül <Herhangi bir Eşya yada Para> dikkatli ol karşına yılan çıkabilir..\n"+
                    "0 - Çıkış Yap\n"+
                    "Lütfen gitmek istediğiniz bölgeyi seçiniz : ");
            int selectLoc = scan.nextInt();
            switch (selectLoc){
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;
                case 6:
                    location = new Mine(player);
                    break;
                default:
                    System.out.println("Lütfen geçerli bir ifade giriniz !");
            }

            if (selectLoc == 3 && new Cave(player).getPlayer().getInventory().isFood()){
                System.out.println("Burasaı tamamlandı.");
                continue;
            }

            if (selectLoc == 4 && new Cave(player).getPlayer().getInventory().isFirewood()){
                System.out.println("Burasaı tamamlandı.");
                continue;
            }

            if (selectLoc == 5 && new Cave(player).getPlayer().getInventory().isWater()){
                System.out.println("Burasaı tamamlandı.");
                continue;
            }

            if (new SafeHouse(player).finish()){
                break;
            }

            if (location == null) {
                System.out.println("Oyun Bitti");
                break;
            }
            if(!location.onLocation()){
                System.out.println("GAME OVER");
                break;
            }
        }
    }
}
