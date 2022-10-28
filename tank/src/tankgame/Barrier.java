package tankgame;

public class Barrier {
    private int x;
    private int y;
    boolean isPenetratable;
    boolean isSmashable;
    boolean isLive = true;

    public Barrier(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
