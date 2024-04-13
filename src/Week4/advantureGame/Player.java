package Week4.advantureGame;

import java.util.Scanner;

public class Player {
    private String name;
    private int damage;
    private  int health;
    private int orijinalHealth;
    private int money;
    private String charName;
    private Inventory inventory;
    Scanner scan = new Scanner(System.in);

    // Kurucu Metot
    public Player(String name){
        this.name = name;
        this.inventory = new Inventory();
    }

    public void charInfo(){
        // Burada charList adında bir dizi oluşturup içerisine karakter nesnelerimizi verdik.
        GameChar[] charList = {new Samurai(), new Archer(), new Knight()};
        // Bu karakterlerin özelliklerini ekrana yazdıran yeni nesil bir for döngüsü tanımladık
        for (GameChar gameChar : charList){
            System.out.println("ID : " + gameChar.getId()+
                    "\tKarakter : " + gameChar.getName() +
                    "\tHasar : " + gameChar.getDamage()+
                    "\tSağlık : " + gameChar.getHealth() +
                    "\tPara : " + gameChar.getMoney());
            System.out.println("----------------------------------");
        }
    }

    // Karakter seçimi metodu
    public void selectChar(){
        charInfo();
        // karakterlerin ID numaralarını ve isimlerini kullanıcıya göstermek üzere ekrana yazdırdık ve
        // kullanıcıdan bir seçim yapmasını istedik
        System.out.print("Bir karakter ID seçiniz : ");
        int selectChar = scan.nextInt();
        System.out.println("----------------------------------");
        // burada kullanıcının seçimine göre initPlayer metodunu çağırdık ve içerisine seçtiğimiz karakteri koyduk.
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
        // burada seçilen karakterin bilgilerini ekrana yazdırdık.
//        System.out.println("Seçtiğiniz Karakter : " + this.getCharName().toUpperCase() +
//                " | HASAR GÜCÜ : " + this.getDamage()+
//                " | SAĞLIK : " + this.getHealth()+
//                " | PARA : " + this.getMoney());
    }

    // initPlayer metodu oyuncunun özelliklerini parametre olarak verdiğimiz karakterin özellikleri ile değiştiriyor.
    public void initPlayer(GameChar gameChar){
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setOrijinalHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());
    }

    public void printInfo(){
        System.out.println("Silahın : " + this.getInventory().getWeapon().getName()+
                " - Zırhın : " + this.getInventory().getArmour().getName()+
                " - Bloklama : " + this.getInventory().getArmour().getBlock()+
                " - Hasarın : " + this.getTotalDamage() +
                " - Sağlığın : " + this.getHealth() +
                " - Paran : " + this.getMoney());
    }

    public int getTotalDamage(){
        return damage + this.getInventory().getWeapon().getDamage();
    }



    // ---------------------------------- Getter ve Setter ----------------------------------
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

    public int getOrijinalHealth() {
        return orijinalHealth;
    }

    public void setOrijinalHealth(int orijinalHealth) {
        this.orijinalHealth = orijinalHealth;
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
    public Inventory getInventory() {
        return inventory;
    }
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

}