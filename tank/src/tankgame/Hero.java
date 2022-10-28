package tankgame;

import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;
import org.omg.CORBA.VersionSpecHelper;
import sun.awt.windows.ThemeReader;

import java.util.Vector;

public class Hero extends Tank {

    Shot shot = null;
    Vector<Shot> shots = new Vector<>();
    Vector<EnemyTank> enemyTanks = new Vector<>();
    Vector<BrickWall> brickWalls = new Vector<>();
    Vector<IronWall> ironWalls = new Vector<>();
    River river = null;

    public Hero(int x, int y) {
        super(x, y);
    }

    public void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        this.enemyTanks = enemyTanks;
    }

    public void setBrickWalls(Vector<BrickWall> brickWalls) {
        this.brickWalls = brickWalls;
    }

    public void setIronWalls(Vector<IronWall> ironWalls) {
        this.ironWalls = ironWalls;
    }

    public void setRiver(River river) {
        this.river = river;
    }

    public void shotEnenmyTank() {

        if (shots.size() == 5) {
            return;
        }

        switch (getDirect()) {
            case 0:
                shot = new Shot(getX() + 20, getY(), 0);
                break;
            case 1:
                shot = new Shot(getX() + 60, getY() + 20, 1);
                break;
            case 2:
                shot = new Shot(getX() + 20, getY() + 60, 2);
                break;
            case 3:
                shot = new Shot(getX(), getY() + 20, 3);
                break;
        }

        shots.add(shot);

        new Thread(shot).start();

    }

    public boolean heroisTouchEnemyTank() {
        switch (this.getDirect()) {
            case 0:
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                        if (this.getX() >= enemyTank.getX()
                                && this.getX() <= enemyTank.getX() + 40
                                && this.getY() >= enemyTank.getY()
                                && this.getY() <= enemyTank.getY() + 60) {
                            return true;
                        }
                        if (this.getX() + 40 >= enemyTank.getX()
                                && this.getX() + 40 <= enemyTank.getX() + 40
                                && this.getY() >= enemyTank.getY()
                                && this.getY() <= enemyTank.getY() + 60) {
                            return true;
                        }
                    }
                    if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
                        if (this.getX() >= enemyTank.getX()
                                && this.getX() <= enemyTank.getX() + 60
                                && this.getY() >= enemyTank.getY()
                                && this.getY() <= enemyTank.getY() + 40) {
                            return true;
                        }
                        if (this.getX() + 40 >= enemyTank.getX()
                                && this.getX() + 40 <= enemyTank.getX() + 60
                                && this.getY() >= enemyTank.getY()
                                && this.getY() <= enemyTank.getY() + 40) {
                            return true;
                        }
                    }
                }
                break;
            case 1:
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                        if (this.getX() + 60 >= enemyTank.getX()
                                && this.getX() + 60 <= enemyTank.getX() + 40
                                && this.getY() >= enemyTank.getY()
                                && this.getY() <= enemyTank.getY() + 60) {
                            return true;
                        }
                        if (this.getX() + 60 >= enemyTank.getX()
                                && this.getX() + 60 <= enemyTank.getX() + 40
                                && this.getY() + 40 >= enemyTank.getY()
                                && this.getY() + 40 <= enemyTank.getY() + 60) {
                            return true;
                        }
                    }
                    if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
                        if (this.getX() + 60 >= enemyTank.getX()
                                && this.getX() + 60 <= enemyTank.getX() + 60
                                && this.getY() >= enemyTank.getY()
                                && this.getY() <= enemyTank.getY() + 40) {
                            return true;
                        }
                        if (this.getX() + 60 >= enemyTank.getX()
                                && this.getX() + 60 <= enemyTank.getX() + 60
                                && this.getY() + 40 >= enemyTank.getY()
                                && this.getY() + 40 <= enemyTank.getY() + 40) {
                            return true;
                        }
                    }
                }
                break;
            case 2:
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                        if (this.getX() >= enemyTank.getX()
                                && this.getX() <= enemyTank.getX() + 40
                                && this.getY() + 60 >= enemyTank.getY()
                                && this.getY() + 60 <= enemyTank.getY() + 60) {
                            return true;
                        }
                        if (this.getX() + 40 >= enemyTank.getX()
                                && this.getX() + 40 <= enemyTank.getX() + 40
                                && this.getY() + 60 >= enemyTank.getY()
                                && this.getY() + 60 <= enemyTank.getY() + 60) {
                            return true;
                        }
                    }
                    if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
                        if (this.getX() >= enemyTank.getX()
                                && this.getX() <= enemyTank.getX() + 60
                                && this.getY() + 60 >= enemyTank.getY()
                                && this.getY() + 60 <= enemyTank.getY() + 40) {
                            return true;
                        }
                        if (this.getX() + 40 >= enemyTank.getX()
                                && this.getX() + 40 <= enemyTank.getX() + 60
                                && this.getY() + 60 >= enemyTank.getY()
                                && this.getY() + 60 <= enemyTank.getY() + 40) {
                            return true;
                        }
                    }
                }
                break;
            case 3:
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                        if (this.getX() >= enemyTank.getX()
                                && this.getX() <= enemyTank.getX() + 40
                                && this.getY() >= enemyTank.getY()
                                && this.getY() <= enemyTank.getY() + 60) {
                            return true;
                        }
                        if (this.getX() >= enemyTank.getX()
                                && this.getX() <= enemyTank.getX() + 40
                                && this.getY() + 40 >= enemyTank.getY()
                                && this.getY() + 40 <= enemyTank.getY() + 60) {
                            return true;
                        }
                    }
                    if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
                        if (this.getX() >= enemyTank.getX()
                                && this.getX() <= enemyTank.getX() + 60
                                && this.getY() >= enemyTank.getY()
                                && this.getY() <= enemyTank.getY() + 40) {
                            return true;
                        }
                        if (this.getX() >= enemyTank.getX()
                                && this.getX() <= enemyTank.getX() + 60
                                && this.getY() + 40 >= enemyTank.getY()
                                && this.getY() + 40 <= enemyTank.getY() + 40) {
                            return true;
                        }
                    }
                }
                break;
        }
        return false;
    }

    public boolean heroIsTouchRiver() {
        switch (this.getDirect()) {
            case 0:
                if (this.getX() > river.getX() - 40
                        && this.getX() < river.getX() + 600
                        && this.getY() >= river.getY()
                        && this.getY() <= river.getY() + 30) {
                    return true;
                }
                break;
            case 1:
                if (this.getX() + 60 >= river.getX()
                        && this.getX() + 60 <= river.getX() + 600
                        && this.getY() > river.getY() - 40
                        && this.getY() < river.getY() + 30) {
                    return true;
                }
                break;
            case 2:
                if (this.getX() > river.getX() - 40
                        && this.getX() < river.getX() + 600
                        && this.getY() + 60 >= river.getY()
                        && this.getY() + 60 <= river.getY() + 30) {
                    return true;
                }
                break;
            case 3:
                if (this.getX() >= river.getX()
                        && this.getX() <= river.getX() + 600
                        && this.getY() > river.getY() - 40
                        && this.getY() < river.getY() + 30) {
                    return true;
                }
                break;
        }
        return false;
    }

    public boolean heroIsTouchBrickWall() {
        switch (this.getDirect()) {
            case 0:
                for (int i = 0; i < brickWalls.size(); i++) {
                    BrickWall brickWall = brickWalls.get(i);
                    if (this.getX() > brickWall.getX() - 40
                            && this.getX() < brickWall.getX() + 10
                            && this.getY() >= brickWall.getY()
                            && this.getY() <= brickWall.getY() + 15) {
                        return true;
                    }
                }
                break;
            case 1:
                for (int i = 0; i < brickWalls.size(); i++) {
                    BrickWall brickWall = brickWalls.get(i);
                    if (this.getX() + 60 >= brickWall.getX()
                            && this.getX() + 60 <= brickWall.getX() + 10
                            && this.getY() > brickWall.getY() - 40
                            && this.getY() < brickWall.getY() + 15) {
                        return true;
                    }
                }
                break;
            case 2:
                for (int i = 0; i < brickWalls.size(); i++) {
                    BrickWall brickWall = brickWalls.get(i);
                    if (this.getX() > brickWall.getX() - 40
                            && this.getX() < brickWall.getX() + 10
                            && this.getY() + 60 >= brickWall.getY()
                            && this.getY() + 60 <= brickWall.getY() + 15) {
                        return true;
                    }
                }
                break;
            case 3:
                for (int i = 0; i < brickWalls.size(); i++) {
                    BrickWall brickWall = brickWalls.get(i);
                    if (this.getX() >= brickWall.getX()
                            && this.getX() <= brickWall.getX() + 10
                            && this.getY() > brickWall.getY() - 40
                            && this.getY() < brickWall.getY() + 15) {
                        return true;
                    }
                }
                break;
        }
        return false;
    }

    public boolean heroIsTouchIronWall() {
        switch (this.getDirect()) {
            case 0:
                for (int i = 0; i < ironWalls.size(); i++) {
                    IronWall ironWall = ironWalls.get(i);
                    if (this.getX() > ironWall.getX() - 40
                            && this.getX() < ironWall.getX() + 15
                            && this.getY() >= ironWall.getY()
                            && this.getY() <= ironWall.getY() + 15) {
                        return true;
                    }
                }
                break;
            case 1:
                for (int i = 0; i < ironWalls.size(); i++) {
                    IronWall ironWall = ironWalls.get(i);
                    if (this.getX() + 60 >= ironWall.getX()
                            && this.getX() + 60 <= ironWall.getX() + 15
                            && this.getY() > ironWall.getY() - 40
                            && this.getY() < ironWall.getY() + 15) {
                        return true;
                    }
                }
                break;
            case 2:
                for (int i = 0; i < ironWalls.size(); i++) {
                    IronWall ironWall = ironWalls.get(i);
                    if (this.getX() > ironWall.getX() - 40
                            && this.getX() < ironWall.getX() + 15
                            && this.getY() + 60 >= ironWall.getY()
                            && this.getY() + 60 <= ironWall.getY() + 15) {
                        return true;
                    }
                }
                break;
            case 3:
                for (int i = 0; i < ironWalls.size(); i++) {
                    IronWall ironWall = ironWalls.get(i);
                    if (this.getX() >= ironWall.getX()
                            && this.getX() <= ironWall.getX() + 15
                            && this.getY() > ironWall.getY() - 40
                            && this.getY() < ironWall.getY() + 15) {
                        return true;
                    }
                }
                break;
        }
        return false;
    }

}


