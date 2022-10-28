package tankgame;

public class BrickWall extends Barrier {
    public BrickWall(int x, int y) {
        super(x, y);
        isPenetratable = false;
        isSmashable = true;
    }
}
