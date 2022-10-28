package tankgame;

public class Tank {
    private int x;
    private int y;
    private int direct;//坦克方向 0上 1右 2下 3左
    private int speed = 1;
    boolean isLive = true;

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //上右下左移动方法
    public void moveUp() {
        if (getY() < speed) {
            y -= getY();
        } else {
            y -= speed;
        }
    }
    public void moveRight() {
        if ((1000 - getX()) < speed) {
            x += (1000 - getX());
        } else {
            x += speed;
        }
    }
    public void moveDown() {
        if ((750 - getY()) < speed) {
            y += (750 - getY());
        } else {
            y += speed;
        }
    }
    public void moveLeft() {
        if (getX() < speed) {
            x -= getX();
        } else {
            x -= speed;
        }
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

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

}
