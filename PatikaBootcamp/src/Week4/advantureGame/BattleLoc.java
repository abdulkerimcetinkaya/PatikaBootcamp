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

    @Override
    public boolean onLocation() {
        int obsNumber = randomObstacleNumber();
        System.out.println("Şuan buradasınız : " + this.getName());
        System.out.println("Dikkatli ol ! Burada "+ obsNumber + " tane " + this.getObstacle().getName()+ " var...");
        System.out.print("<S>avaşacak mısın? yoksa <K>açacak mısın? : ");
        String selectCase = scan.nextLine();
        if (selectCase.equalsIgnoreCase("s")) {
            System.out.println("Savaşma işlemleri olacak..");
        }
        return true;
    }

    public int randomObstacleNumber(){
        Random rand = new Random();
        return rand.nextInt(this.getMaxObstacle())+1;
    }

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
