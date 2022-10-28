package tankgame;

public class IronWall extends Barrier {
    public IronWall(int x, int y) {
        super(x, y);
        isPenetratable = false;
        isSmashable = false;
    }
}
