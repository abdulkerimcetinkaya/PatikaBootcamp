package Week4.advantureGame;

public abstract class Location {
    private int id;
    private Player player;
    private String name;

    public Location(Player player, String name){
        this.player = player;
        this.name = name;
    }

    public abstract boolean onLocation();

    // Getter ve Setter metodlar
    public Player getPlayer() {return player;}
    public void setPlayer(Player player) {this.player = player;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
}
