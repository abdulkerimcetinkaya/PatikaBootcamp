package Week4.advantureGame;

public class ToolStore extends NormalLoc{
    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Mağazaya Hoşgeldiniz !");
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
            case 3:
                System.out.println("Tekrar bekleriz.");
                return true;
        }

        return true;
    }

    public void printWeapon(){
        System.out.println("-------- Silahlar --------");
        for(Weapon w : Weapon.weapons()){
            System.out.println(w.getName() +
                    " > ID : " + w.getId() +
                    " Hasar : " + w.getDamage() +
                    " Para : " + w.getPrice());
        }

    }

    public void buyWeapon(){
        System.out.print("Bir silah seçiniz : ");
        int selectWeaponID = scan.nextInt();
        while (selectWeaponID < 1 || selectWeaponID > Weapon.weapons().length ){
            System.out.println("Gerçersiz işlem");
            selectWeaponID = scan.nextInt();
        }

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

    public void printArmour(){
        System.out.println("Zırhlar");
    }
}
