package Week4.advantureGame;

public class ToolStore extends NormalLoc{
    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Mağazaya Hoşgeldiniz !");
        boolean showMenu = true;
        while (showMenu){
            System.out.println("1 - Silahlar\n2 - Zırhlar\n3 - Çıkış yap");
            System.out.print("Seçiminiz : ");
            int selectCase = scan.nextInt();
            while (selectCase < 1 || selectCase > 3 ){
                System.out.println("Gerçersiz işlem");
                selectCase = scan.nextInt();
            }
            switch (selectCase){
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmour();
                    buyArmour();
                case 3:
                    System.out.println("Tekrar bekleriz.");
                    showMenu = false;
                    break;
            }
        }
        return true;
    }
    public void printWeapon(){
        System.out.println("-------- Silahlar --------");
        for(Weapon w : Weapon.weapons()){
            System.out.println(w.getName() +
                    " -> ID : " + w.getId() +
                    " Hasar : " + w.getDamage() +
                    " Para : " + w.getPrice());
        }
        System.out.println("0 - Çıkış Yap");
    }

    public void buyWeapon(){
        System.out.print("Bir silah seçiniz : ");
        int selectWeaponID = scan.nextInt();
        while (selectWeaponID < 0 || selectWeaponID > (Weapon.weapons().length)){
            System.out.print("Gerçersiz işlem, Tekrar giriniz : ");
            selectWeaponID = scan.nextInt();
        }

        if (selectWeaponID != 0) {
            Weapon selectedWeapon = Weapon.getWeaponObjByID(selectWeaponID);
            if (selectedWeapon != null){
                if (selectedWeapon.getPrice() > this.getPlayer().getMoney()){
                    System.out.println("Yeterli bakiyeniz bulunmamaktadır.");
                }else {
                    System.out.println(selectedWeapon.getName() + " Silahını satın aldınız");
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan paranız : "+this.getPlayer().getMoney());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println("Yeni silahınız : " +this.getPlayer().getInventory().getWeapon().getName());
                }
            }
        }
    }
    public void printArmour(){
        System.out.println("-------- Zırhlar --------");
        for (Armour a : Armour.armours()){
            System.out.println(a.getName()+
                    " -> ID : " + a.getId() +
                    " Savunma : " + a.getBlock() +
                    " Para : " + a.getPrice());
        }
        System.out.println("0 - Çıkış Yap");
    }
    public void buyArmour(){
        System.out.print("Bir zırh seçiniz : ");
        int selectArmourID = scan.nextInt();
        while (selectArmourID < 0 || selectArmourID > Armour.armours().length ){
            System.out.print("Gerçersiz işlem, tekrar giriniz : ");
            selectArmourID = scan.nextInt();
        }

        if (selectArmourID != 0){
            Armour selectedArmour = Armour.getArmourObjByID(selectArmourID);
            if (selectedArmour != null){
                if (selectedArmour.getPrice() > this.getPlayer().getMoney()){
                    System.out.println("Yeterli bakiyeniz bulunmamaktadır.");
                }else {
                    System.out.println(selectedArmour.getName() + " Zırhını satın aldınız");
                    int balance = this.getPlayer().getMoney() - selectedArmour.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan paranız : "+this.getPlayer().getMoney());
                    this.getPlayer().getInventory().setArmour(selectedArmour);
                    System.out.println("Yeni Zırhınız : " +this.getPlayer().getInventory().getArmour().getName());
                }
            }
        }
    }
}
