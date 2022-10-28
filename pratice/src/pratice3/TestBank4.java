package pratice3;

import java.util.concurrent.locks.ReentrantLock;

class Bank4 {
    private int balance1 = 0;
    private int balance2 = 0;
    private final ReentrantLock lock = new ReentrantLock();
    public void put1(int add1) {
        lock.lock();
        balance1 = balance1 + add1;
        System.out.println("顾客A  您本次汇款：" + add1 + "  总汇款：" + balance1);
    }
    public void put2(int add2) {
        lock.lock();
        balance2 = balance2 + add2;
        System.out.println("顾客B  您本次汇款："+add2+"  总汇款："+balance2);
    }
}

class CustomerA1 extends Thread {
    private Bank2 bank2;
    public CustomerA1(Bank2 b) {
        bank2 = b;
    }
    public void run() {
        for(int i = 0; i < 3; i++) {
            bank2.put1(100);
        }
    }
}

class CustomerB2 extends Thread {
    private Bank2 bank2;
    public CustomerB2(Bank2 b) {
        bank2 = b;
    }
    public void run() {
        for(int i = 0; i < 3; i++) {
            bank2.put2(100);
        }
    }
}

public class TestBank4 {
    public static void main(String[] args) {
        Bank2 bank2 = new Bank2();
        CustomerA1 customera1 = new CustomerA1(bank2);
        CustomerB2 customerb2 = new CustomerB2(bank2);
        customera1.start();
        customerb2.start();
    }
}
