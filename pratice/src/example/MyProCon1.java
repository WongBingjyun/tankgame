package example;

class Store2 {
    private int seq;
    private boolean available = false;
    public synchronized int get() {
        while(available == false) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        available = false;
        notify();
        return seq;
    }

    public synchronized void put(int value) {
        while(available == true) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        seq = value;
        available = true;
        notify();
    }
}

class Producer1 extends Thread {
    private Store2 store;
    private int num;
    public Producer1(Store2 s, int num) {
        store = s;
        this.num = num;
    }
    public void run() {
        for(int i = 0; i < 10; i++) {
            store.put(i);
            System.out.println("Producer #"+this.num+"put:"+i);
            try {
                sleep((int)(Math.random()*100));
            } catch (InterruptedException e) {

            }
        }
    }
}

class Comsumer1 extends Thread {
    private Store2 store;
    private int num;
    public Comsumer1(Store2 s, int num) {
        store = s;
        this.num = num;
    }
    public void run() {
        int value = 0;
        for(int i = 0; i < 10; i++) {
            value = store.get();
            System.out.println("Consumer #"+this.num+"got:"+value);
        }
    }
}

public class MyProCon1 {
    public static void main(String[] args) {
        Store2 s = new Store2();
        Producer1 p2 = new Producer1(s,2);
        Comsumer1 c2 = new Comsumer1(s,2);
        p2.start();
        c2.start();
    }
}
