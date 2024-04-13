package Week4.advantureGame;

import java.util.Random;

public class Snake extends  Obstacle{

    public Snake() {
        super("Yılan", 4, (int)(Math.random() * 4), 1, 0);

    }
}
