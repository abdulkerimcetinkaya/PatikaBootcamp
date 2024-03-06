package Week4.advantureGame;

import java.util.Scanner;

public class Player {
    private String name;
    private int damage;
    private  int health;
    private int money;
    private String charName;
    Scanner scan = new Scanner(System.in);

    // Kurucu Metot
    public Player(String name){
        this.name = name;
    }



    // Karakter seçimi metodu
    public void selectChar(){
        // Burada charList adında bir dizi oluşturup içerisine karakter nesnelerimizi verdik.
        GameChar[] charList = {new Samurai(), new Archer(), new Knight()};
        // Bu karakterlerin özelliklerini ekrana yazdıran yeni nesil bir for döngüsü tanımladık
        for (GameChar gamechar : charList){
            System.out.println("ID : " + gamechar.getId()+
                    "\nKarakter : " + gamechar.getName() +
                    "\nHasar : " + gamechar.getDamage()+
                    "\nSağlık : " + gamechar.getHealth() +
                    "\nPara : " + gamechar.getMoney());
            System.out.println("----------------------------------");
        }
        // karakterlerin
        System.out.print("Samuray (1)\nOkçu (2)\nŞovalye(3)\nLütfen bir karakter seçimi için ID numarası giriniz : ");
        int selectChar = scan.nextInt();
        switch (selectChar){
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
        }

        System.out.println("Seçtiğin karakter : " + this.getCharName() +
                " - Hasar Gücü : " + this.getDamage()+
                " - Sağlığı : " + this.getHealth()+
                " - Parası : " + this.getMoney());
    }

    public void initPlayer(GameChar gameChar){
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());
    }








    // Getter ve Setter metotlar

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }
}