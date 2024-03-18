package Week4.advantureGame;

import java.util.Random;

public abstract class BattleLoc extends  Location{
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;

    public BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }
    // Konum
    @Override
    public boolean onLocation() {
        int obsNumber = randomObstacleNumber();
        System.out.println("Şuan buradasınız : " + this.getName());
        System.out.println("Dikkatli ol ! Burada "+ obsNumber + " tane " + this.getObstacle().getName()+ " var...");
        System.out.print("<S>avaşacak mısın? yoksa <K>açacak mısın? : ");
        String selectCase = scan.nextLine();
        if (selectCase.equalsIgnoreCase("s") && combat(obsNumber)) {
            System.out.println(this.getName() + " alanında ki tüm düşmanları öldürdünüz.");
            awardMethod();
            return true;
        }
        if (this.getPlayer().getHealth() <= 0) {
            System.out.println("Öldünüz!");
            return false;
        }
        return true;
    }

    public void awardMethod(){
        Random random = new Random();
        int num1 = random.nextInt(100);
        int num2 = random.nextInt(56);
        int num3 = random.nextInt(101);
        if (getObstacle().getName().equalsIgnoreCase("yılan")){
            getObstacle().setMoney(10);
        }
        while (num1 < 55){
            // Para kazanma durumu
            if (num2 < 25){
                if (this.award.equalsIgnoreCase("Supriz") &&  num3 < 20){
                    getObstacle().setMoney(10);
                    getPlayer().setMoney(getObstacle().getMoney() + getPlayer().getMoney());
                    break;
                }
                else if(this.award.equalsIgnoreCase("Supriz")&& num3 < 50){
                    getObstacle().setMoney(5);
                    getPlayer().setMoney(getObstacle().getMoney() + getPlayer().getMoney());
                    break;
                }
                else if (this.award.equalsIgnoreCase("Supriz")&& num3 < 100) {
                    getObstacle().setMoney(1);
                    getPlayer().setMoney(getObstacle().getMoney() + getPlayer().getMoney());
                    break;
                }
            }
            // Zırh kazanma ihtimali
            else if (num2 < 40){
                if (this.award.equalsIgnoreCase("Supriz") &&  num3 < 20){
                    getPlayer().getInventory().setArmour(Armour.getArmourObjByID(1));
                    System.out.println(getPlayer().getInventory().armour.getName());
                    break;
                }
                else if(this.award.equalsIgnoreCase("Supriz")&& num3 < 50){
                    getPlayer().getInventory().setArmour(Armour.getArmourObjByID(2));
                    System.out.println(getPlayer().getInventory().armour.getName());
                    break;
                }
                else if (this.award.equalsIgnoreCase("Supriz")&& num3 < 100) {
                    getPlayer().getInventory().setArmour(Armour.getArmourObjByID(3));
                    System.out.println(getPlayer().getInventory().armour.getName());
                    break;
                }
            }
            // Silah kazanma ihtimali
            else if (num2 < 55){
                if (this.award.equalsIgnoreCase("Supriz") &&  num3 < 20){
                    getPlayer().getInventory().setWeapon(Weapon.getWeaponObjByID(1));
                    System.out.println(getPlayer().getInventory().weapon.getName());
                    break;
                }
                else if(this.award.equalsIgnoreCase("Supriz")&& num3 < 50){
                    getPlayer().getInventory().setWeapon(Weapon.getWeaponObjByID(2));
                    System.out.println(getPlayer().getInventory().weapon.getName());
                    break;
                }
                else if (this.award.equalsIgnoreCase("Supriz")&& num3 < 100) {
                    getPlayer().getInventory().setWeapon(Weapon.getWeaponObjByID(3));
                    System.out.println(getPlayer().getInventory().weapon.getName());
                    break;
                }
            }
            else {
                System.out.println("Birşey kazanamadınız.");
            }
        }

        if (this.award.equalsIgnoreCase("food") && this.getPlayer().getInventory().isFood() == false){
            System.out.println(this.award + " kazandınız!");
            getPlayer().getInventory().setFood(true);
        } else if (this.award.equalsIgnoreCase("water") && this.getPlayer().getInventory().isWater() == false) {
            System.out.println(this.award + " kazandınız!");
            getPlayer().getInventory().setWater(true);
        } else if (this.award.equalsIgnoreCase("firewood") && this.getPlayer().getInventory().isFirewood() == false) {
            System.out.println(this.award + " kazandınız!");
            getPlayer().getInventory().setFirewood(true);
        }
    }

    public void firstHit(){
        Random random = new Random();
        int num = random.nextInt(2);
        if (num == 0 && this.getPlayer().getHealth() > 0){
            System.out.println("Vurdunuz");
            this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
            afterHit();

            System.out.println();
            System.out.println("Canavar size vurdu");
            int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmour().getBlock();
            if (obstacleDamage < 0 ) {
                obstacleDamage = 0;
            }
            this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
            afterHit();
        }
        if (num == 1 && this.getObstacle().getHealth() > 0) {
            System.out.println();
            System.out.println("Canavar size vurdu");
            int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmour().getBlock();
            if (obstacleDamage < 0 ) {
                obstacleDamage = 0;
            }
            this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
            afterHit();

            System.out.println("Vurdunuz");
            this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
            afterHit();
        }
    }


    // Savaşma metodu
    public boolean combat(int obsNumber){
        for (int i = 1; i <= obsNumber; i++) {
            this.getObstacle().setHealth(this.getObstacle().getOrijinalHealth());
            playerStats();
            obstacleStats(i);
            while(this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0){
                System.out.print("<V>ur yada <K>aç : ");
                String selectCombat = scan.nextLine();
                // Svaşın başladığı yer
                if (selectCombat.equalsIgnoreCase("v")) {
                    firstHit();
                }else {
                    System.out.println("Kaçtınız.");
                    return false;
                }
            }

            if (this.getObstacle().getHealth() < this.getPlayer().getHealth()){
                System.out.println("Düşmanı yendiniz .");
                System.out.println(this.getObstacle().getMoney() + " para kazandınız.");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getMoney());
                System.out.println("Güncel paranız : " + this.getPlayer().getMoney());
            }else {
                return false;
            }
        }
        return true;
    }


    // Vuruş sonrası can bilgileri
    public void afterHit(){
        System.out.println("Canınız : " + this.getPlayer().getHealth());
        System.out.println(getObstacle().getName() + " Canı : " + this.getObstacle().getHealth());
        System.out.println("---------------------------------");
    }


    // Oyuncunun değerleri
    public void playerStats(){
        System.out.println("Oyuncu değerleri");
        System.out.println("---------------------------------");
        System.out.println("Sağlık : " + this.getPlayer().getHealth());
        System.out.println("Silah : " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Hasar : " + this.getPlayer().getTotalDamage());
        System.out.println("Zırh : " + this.getPlayer().getInventory().getArmour().getName());
        System.out.println("Bloklama : "+ this.getPlayer().getInventory().getArmour().getBlock());
        System.out.println("Para : " + this.getPlayer().getMoney());
        System.out.println();
    }
    // Canavarın değerleri
    public void obstacleStats(int i){
        System.out.println(i + ". " + this.getObstacle().getName()+ " Değerleri");
        System.out.println("---------------------------------");
        System.out.println("Sağlık : " + this.getObstacle().getHealth());
        System.out.println("Hasar : " + this.getObstacle().getDamage());
        System.out.println("Ödül : " + this.getObstacle().getMoney());
        System.out.println();
    }

    public int randomObstacleNumber(){
        Random rand = new Random();
        return rand.nextInt(this.getMaxObstacle())+1;
    }

    // ------------------------- GETTER VE STTER METOTLARI --------------------------------------------
    public Obstacle getObstacle() {
        return obstacle;
    }
    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }
    public String getAward() {
        return award;
    }
    public void setAward(String award) {
        this.award = award;
    }
    public int getMaxObstacle() {
        return maxObstacle;
    }
    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }


}
