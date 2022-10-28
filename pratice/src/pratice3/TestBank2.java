package pratice3;

class Bank2 {
    private int balance1 = 0;
    private int balance2 = 0;
    public synchronized void put1(int add1) {
        balance1 = balance1 + add1;
        System.out.println("顾客A  您本次汇款："+add1+"  总汇款："+balance1);
    }
    public synchronized void put2(int add2) {
        balance2 = balance2 + add2;
        System.out.println("顾客B  您本次汇款："+add2+"  总汇款："+balance2);
    }
}

class Customer1 extends Thread {
    private Bank2 bank2;
    public Customer1(Bank2 b) {
        bank2 = b;
    }
    public void run() {
        for(int i = 0; i < 3; i++) {
            bank2.put1(100);
        }
    }
}

class Customer2 extends Thread {
    private Bank2 bank2;
    public Customer2(Bank2 b) {
        bank2 = b;
    }
    public void run() {
        for(int i = 0; i < 3; i++) {
            bank2.put2(100);
        }
    }
}

public class TestBank2 {
    public static void main(String[] args) {
        Bank2 bank2 = new Bank2();
        Customer1 customer1 = new Customer1(bank2);
        Customer2 customer2 = new Customer2(bank2);
        customer1.start();
        customer2.start();
    }
}
