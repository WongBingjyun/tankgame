package tankgame;

import java.util.Vector;

@SuppressWarnings({"all"})
public class EnemyTank extends Tank implements Runnable {
    Vector<Shot> shots = new Vector<>();
    Vector<EnemyTank> enemyTanks = new Vector<>();
    Vector<Hero> heroes = new Vector<>();
    Vector<BrickWall> brickWalls = new Vector<>();
    Vector<IronWall> ironWalls = new Vector<>();
    River river = null;
    boolean isLive = true;

    public EnemyTank(int x, int y) {
        super(x, y);
    }

    public void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        this.enemyTanks = enemyTanks;
    }

    public void setHeroes(Vector<Hero> heroes) {
        this.heroes = heroes;
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

    public boolean isTouchEnemyTank() {
        switch (this.getDirect()) {
            case 0:
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    if (enemyTank != this) {
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
                }
                break;
            case 1:
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    if (enemyTank != this) {
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
                }
                break;
            case 2:
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    if (enemyTank != this) {
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
                }
                break;
            case 3:
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    if (enemyTank != this) {
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
                }
                break;

        }
        return false;
    }

    public boolean isTouchHero() {
        switch (this.getDirect()) {
            case 0:
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    if (enemyTank != this) {
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
                }
                break;
            case 1:
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    if (enemyTank != this) {
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
                }
                break;
            case 2:
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    if (enemyTank != this) {
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
                }
                break;
            case 3:
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    if (enemyTank != this) {
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
                }
                break;

        }
        return false;
    }

    public boolean enemyIsTouchRiver() {
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

    public boolean enemyIsTouchBrickWall() {
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

    public boolean enemyIsTouchIronWall() {
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

    public void run() {
        while (true) {

            if (isLive && shots.size() == 0) {
                Shot s = null;
                switch (getDirect()) {
                    case 0:
                        s = new Shot(getX() + 20, getY(), 0);
                        break;
                    case 1:
                        s = new Shot(getX() + 60, getY() + 20, 1);
                        break;
                    case 2:
                        s = new Shot(getX() + 20, getY() + 60, 2);
                        break;
                    case 3:
                        s = new Shot(getX(), getY() + 20, 3);
                        break;
                }
                shots.add(s);
                new Thread(s).start();
            }

            switch (getDirect()) {
                case 0:
                    for (int i = 0; i < 70; i++) {
                        if (getY() > 0 && !isTouchEnemyTank() && !isTouchHero() && !enemyIsTouchBrickWall()
                                && !enemyIsTouchIronWall() && ! enemyIsTouchRiver()) {
                            moveUp();
                        } else {
                            continue;
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 1:
                    for (int i = 0; i < 70; i++) {
                        if (getX() + 60 < 1000 && !isTouchEnemyTank() && !isTouchHero() && !enemyIsTouchBrickWall()
                                && !enemyIsTouchIronWall() && ! enemyIsTouchRiver()) {
                            moveRight();
                        } else {
                            continue;
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < 70; i++) {
                        if (getY() + 60 < 750 && !isTouchEnemyTank() && !isTouchHero() && !enemyIsTouchBrickWall()
                                && !enemyIsTouchIronWall() && ! enemyIsTouchRiver()) {
                            moveDown();
                        } else {
                            continue;
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < 70; i++) {
                        if (getX() > 0 && !isTouchEnemyTank() && !isTouchHero() && !enemyIsTouchBrickWall()
                                && !enemyIsTouchIronWall() && ! enemyIsTouchRiver()) {
                            moveLeft();
                        } else {
                            continue;
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
            }

            setDirect((int) (Math.random() * 4));
            if (!isLive) {
                break;
            }
        }
    }

}
