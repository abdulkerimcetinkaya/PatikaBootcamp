package Week4.advantureGame;

public class Inventory {
    Weapon weapon;
    Armour armour;
    private boolean water,food,firewood;


    public Inventory(){
        this.weapon = new Weapon("Yumruk",-1,0,0);
        this.armour = new Armour("Paçavra", -1,0,0);
        this.water = false;
        this.food = false;
        this.firewood = false;
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

    public boolean isWater() {
        return water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean isFirewood() {
        return firewood;
    }

    public void setFirewood(boolean firewood) {
        this.firewood = firewood;
    }
}
