package tankgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class Mypanel extends JPanel implements KeyListener, Runnable {

    Hero hero = null;
    River river = null;
    Vector<EnemyTank> enemyTanks = new Vector<>();
    Vector<Hero> heroes = new Vector<>();
    Vector<BrickWall> brickWalls = new Vector<>();
    Vector<IronWall> ironWalls = new Vector<>();
    int enemyTankSize = 5;
    int heroSize = 3;
    int brickSize = 60;
    int ironSize = 40;

    public Mypanel() {

        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < brickSize; i++) {
                BrickWall brickWall = new BrickWall((175 + (10 * i)), 185 + (15 * j));
                brickWalls.add(brickWall);
            }
        }

        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < ironSize; i++) {
                IronWall ironWall = new IronWall((175 + (15 * i)), 350 + (15 * j));
                ironWalls.add(ironWall);
            }
        }

        river = new River(175, 530);

        for (int i = 0; i < enemyTankSize; i++) {
            EnemyTank enemyTank = new EnemyTank((100 * (i + 1)), 0);
            enemyTank.setEnemyTanks(enemyTanks);
            enemyTank.setBrickWalls(brickWalls);
            enemyTank.setIronWalls(ironWalls);
            enemyTank.setRiver(river);
            enemyTank.setDirect(2);
            new Thread(enemyTank).start();
            Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirect());
            enemyTank.shots.add(shot);
            new Thread(shot).start();
            enemyTanks.add(enemyTank);
        }
        for (int i = 0; i < heroSize; i++) {
            hero = new Hero(450, 600);
            hero.setSpeed(5);
            heroes.add(hero);
            hero.setEnemyTanks(enemyTanks);
            hero.setBrickWalls(brickWalls);
            hero.setIronWalls(ironWalls);
            hero.setRiver(river);
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);

        drawBarrire(river.getX(), river.getY(), g, 0);

        for (int i = 0; i < brickWalls.size(); i++) {
            BrickWall brickWall = brickWalls.get(i);
            if (brickWall.isLive) {
                drawBarrire(brickWall.getX(), brickWall.getY(), g, 1);
            }
        }

        for (int i = 0; i < ironWalls.size(); i++) {
            IronWall ironWall = ironWalls.get(i);
            if (ironWall.isLive) {
                drawBarrire(ironWall.getX(), ironWall.getY(), g, 2);
            }
        }

        for (int i = 0; i < heroes.size(); i++) {
            hero = heroes.get(i);
            if (hero.isLive) {
                drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 1);
                break;
            }
        }

        for (int i = 0; i < hero.shots.size(); i++) {
            Shot shot = hero.shots.get(i);
            if (shot != null && shot.isLive == true) {
                g.draw3DRect(shot.x, shot.y, 1, 1, false);
            } else {
                hero.shots.remove(shot);
            }
        }

        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            if (enemyTank.isLive) {
                drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 0);
                for (int j = 0; j < enemyTank.shots.size(); j++) {
                    Shot shot = enemyTank.shots.get(j);
                    if (shot.isLive) {
                        g.draw3DRect(shot.x, shot.y, 1, 1, false);
                    } else {
                        enemyTank.shots.remove(shot);
                    }
                }
            }
        }
        display(g);
    }

    public void drawTank(int x, int y, Graphics g, int direct, int type) {
        switch (type) {
            case 0:
                g.setColor(Color.PINK);
                break;
            case 1:
                g.setColor(Color.yellow);

                break;
        }
        switch (direct) {
            case 0:
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y);
                break;
            case 1:
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x + 60, y + 20);
                break;
            case 2:
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y + 60);
                break;
            case 3:
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x, y + 20);
                break;
            default:
                System.out.println("暂时没有处理");
        }
    }

    //0代表河流，1代表砖块，2代表铁块
    public void drawBarrire(int x, int y, Graphics g, int type) {
        switch (type) {
            case 0:
                g.setColor(Color.cyan);
                g.fill3DRect(x, y, 600, 30, false);
                g.setColor(Color.BLACK);
                g.drawRect(x, y, 600, 30);
                break;
            case 1:
                g.setColor(Color.ORANGE);
                g.fill3DRect(x, y, 10, 15, false);
                g.setColor(Color.BLACK);
                g.drawRect(x, y, 10, 15);
                break;
            case 2:
                g.setColor(Color.LIGHT_GRAY);
                g.fill3DRect(x, y, 15, 15, false);
                g.setColor(Color.BLACK);
                g.drawRect(x, y, 15, 15);
                break;
            default:
                System.out.println("暂时没有处理");
        }
    }

    public void hitTank(Shot s, Tank Tank) {
        switch (Tank.getDirect()) {
            case 0:
            case 2:
                if (s.x > Tank.getX() && s.x < Tank.getX() + 40
                        && s.y > Tank.getY() && s.y < Tank.getY() + 60) {
                    s.isLive = false;
                    Tank.isLive = false;
                    enemyTanks.remove(Tank);
                }
                break;
            case 1:
            case 3:
                if (s.x > Tank.getX() && s.x < Tank.getX() + 60
                        && s.y > Tank.getY() && s.y < Tank.getY() + 40) {
                    s.isLive = false;
                    Tank.isLive = false;
                    enemyTanks.remove(Tank);
                }
                break;
        }
    }

    public void hitEnemyTank() {
        for (int j = 0; j < hero.shots.size(); j++) {
            Shot shot = hero.shots.get(j);
            if (shot != null && shot.isLive) {
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    hitTank(shot, enemyTank);
                }
            }
        }
    }

    public void hitHero() {
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            for (int j = 0; j < enemyTank.shots.size(); j++) {
                Shot shot = enemyTank.shots.get(j);
                if (hero.isLive && shot.isLive) {
                    hitTank(shot, hero);
                }
            }
        }
    }

    public void hitBrick() {
        for (int j = 0; j < hero.shots.size(); j++) {
            Shot shot = hero.shots.get(j);
            if (shot != null && shot.isLive) {
                for (int i = 0; i < brickWalls.size(); i++) {
                    BrickWall brickWall = brickWalls.get(i);
                    if (shot.x > brickWall.getX() && shot.x < brickWall.getX() + 10
                            && shot.y > brickWall.getY() && shot.y < brickWall.getY() + 15) {
                        shot.isLive = false;
                        brickWall.isLive = false;
                        brickWalls.remove(brickWall);
                    }
                }
            }
        }
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            for (int j = 0; j < enemyTank.shots.size(); j++) {
                Shot shot = enemyTank.shots.get(j);
                if (shot != null && shot.isLive) {
                    for (int k = 0; k < brickWalls.size(); k++) {
                        BrickWall brickWall = brickWalls.get(k);
                        if (shot.x > brickWall.getX() && shot.x < brickWall.getX() + 10
                                && shot.y > brickWall.getY() && shot.y < brickWall.getY() + 15) {
                            shot.isLive = false;
                            brickWall.isLive = false;
                            brickWalls.remove(brickWall);
                        }
                    }
                }
            }
        }
    }

    public void hitIron() {
        for (int j = 0; j < hero.shots.size(); j++) {
            Shot shot = hero.shots.get(j);
            if (shot != null && shot.isLive) {
                for (int i = 0; i < ironWalls.size(); i++) {
                    IronWall ironWall = ironWalls.get(i);
                    if (shot.x > ironWall.getX() && shot.x < ironWall.getX() + 15
                            && shot.y > ironWall.getY() && shot.y < ironWall.getY() + 15) {
                        shot.isLive = false;
                    }
                }
            }
        }
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            for (int j = 0; j < enemyTank.shots.size(); j++) {
                Shot shot = enemyTank.shots.get(j);
                if (shot != null && shot.isLive) {
                    for (int k = 0; k < ironWalls.size(); k++) {
                        IronWall ironWall = ironWalls.get(k);
                        if (shot.x > ironWall.getX() && shot.x < ironWall.getX() + 15
                                && shot.y > ironWall.getY() && shot.y < ironWall.getY() + 15) {
                            shot.isLive = false;
                        }
                    }
                }
            }
        }
    }

    public void display(Graphics g) {
        int heroLife = 0;
        for (int i = 0; i < heroes.size(); i++) {
            if (heroes.get(i).isLive == true) {
                heroLife++;
            }
        }
        g.setColor(Color.black);
        g.setFont(new Font("黑体",Font.PLAIN,30));
        g.drawString("Enemy:", 1040, 40);
        g.drawString("You:", 1040, 190);
        g.setFont(new Font("黑体",Font.PLAIN,30));
        g.drawString("" + enemyTanks.size(), 1120, 90);
        g.drawString("" + heroLife, 1120, 240);

        drawTank(1040, 50, g, 0, 0);
        drawTank(1040, 200, g, 0, 1);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            hero.setDirect(0);
            if (hero.getY() > 0 && !hero.heroisTouchEnemyTank() && !hero.heroIsTouchBrickWall()
                    && !hero.heroIsTouchIronWall() && !hero.heroIsTouchRiver()) {
                hero.moveUp();
            }

        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            hero.setDirect(1);
            if (hero.getX() + 60 < 1000 && !hero.heroisTouchEnemyTank() && !hero.heroIsTouchBrickWall()
                    && !hero.heroIsTouchIronWall() && !hero.heroIsTouchRiver()) {
                hero.moveRight();
            }

        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            hero.setDirect(2);
            if (hero.getY() + 60 < 750 && !hero.heroisTouchEnemyTank() && !hero.heroIsTouchBrickWall()
                    && !hero.heroIsTouchIronWall() && !hero.heroIsTouchRiver()) {
                hero.moveDown();
            }

        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            hero.setDirect(3);
            if (hero.getX() > 0 && !hero.heroisTouchEnemyTank() && !hero.heroIsTouchBrickWall()
                    && !hero.heroIsTouchIronWall() && !hero.heroIsTouchRiver()) {
                hero.moveLeft();
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_J) {
            hero.shotEnenmyTank();
        }

        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {

        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            hitEnemyTank();
            hitHero();
            hitBrick();
            hitIron();
            this.repaint();
        }
    }
}
