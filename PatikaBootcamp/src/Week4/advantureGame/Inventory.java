package Week4.advantureGame;

public class Inventory {
    Weapon weapon;
    Armour armour;

    public Inventory(){
        this.weapon = new Weapon("Yumruk",-1,0,0);
        this.armour = new Armour("Paçavra", -1,0,0);
    }


    public Weapon getWeapon() {
        return weapon;
    }
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armour getArmour() {
        return armour;
    }

    public void setArmour(Armour armour) {
        this.armour = armour;
    }
}
