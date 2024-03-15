package Week4.advantureGame;

public class SafeHouse extends NormalLoc {
    public SafeHouse(Player player) {
        super(player, "Güvenli ev");
    }

    public boolean onLocation() {
        System.out.println("Güvenli eve giriş yaptınız canınız yenileniyor...");
        this.getPlayer().setHealth(this.getPlayer().getOrijinalHealth());
        return true;
    }

    public boolean finish(){
        if (this.getPlayer().getInventory().isFood() && this.getPlayer().getInventory().isWater() && this.getPlayer().getInventory().isFirewood()){
            System.out.println("Tebrikler oyunu bitirdiniz.");
            return true;
        }
        return false;
    }


}
