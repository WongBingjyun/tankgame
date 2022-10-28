package pratice3;

class Bank3 {
    private int balance1 = 0;
    private int balance2 = 0;
    public void put1(int add1) {
        synchronized (this) {
            balance1 = balance1 + add1;
            System.out.println("顾客A  您本次汇款：" + add1 + "  总汇款：" + balance1);
        }
    }
    public void put2(int add2) {
        synchronized (this) {
            balance2 = balance2 + add2;
            System.out.println("顾客B  您本次汇款："+add2+"  总汇款："+balance2);
        }
    }
}

class CustomerA extends Thread {
    private Bank2 bank2;
    public CustomerA(Bank2 b) {
        bank2 = b;
    }
    public void run() {
        for(int i = 0; i < 3; i++) {
            bank2.put1(100);
        }
    }
}

class CustomerB extends Thread {
    private Bank2 bank2;
    public CustomerB(Bank2 b) {
        bank2 = b;
    }
    public void run() {
        for(int i = 0; i < 3; i++) {
            bank2.put2(100);
        }
    }
}

public class TestBank3 {
    public static void main(String[] args) {
        Bank2 bank2 = new Bank2();
        CustomerA customera = new CustomerA(bank2);
        CustomerB customerb = new CustomerB(bank2);
        customera.start();
        customerb.start();
    }
}
