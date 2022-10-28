package example;

class AThread extends Thread {
    public AThread(String str) {
        super(str);
    }
    public void run() {
        for(int i = 0; i < 10; i++) {
            System.out.println(i + " "+getName());
            try {
                sleep((int)(Math.random()*1000));
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("END!"+getName());
    }
}

public class MyThread {
    public static void main(String[] args) {
        new AThread("win").start();
        new AThread("Lost").start();
    }
}
