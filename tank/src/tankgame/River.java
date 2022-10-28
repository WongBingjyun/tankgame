package tankgame;

public class River extends Barrier {
    public River(int x, int y) {
        super(x, y);
        isPenetratable = true;
        isSmashable = false;
    }
}
