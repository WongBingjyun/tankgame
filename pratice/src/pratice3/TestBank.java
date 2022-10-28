package pratice3;

class Account {
    String name;
    int money;
    public Account(String name, int money) {
        this.name = name;
        this.money = money;
    }
}

class Bank {
    private int balance;
    private boolean available = true;
    public Bank(int money) {
        this.balance = money;
    }
    public synchronized void put(int add) {
        while (available == false) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        balance = balance + add;
        System.out.println("您本次存款"+add+"元，存款后银行卡余额："+balance+"元。");
        available = false;
        notify();
    }
    public synchronized void get(int minus) {
        while (available == true) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        if(minus > balance) {
            System.out.println("您本次想要取款"+minus+"元，银行卡剩余余额为："+balance+"，取款失败！");
            available = true;
            notify();
        } else {
            balance = balance - minus;
            System.out.println("您本次取款"+minus+"元，取款后银行卡余额："+balance+"元。");
            available = true;
            notify();
        }
    }
}


class Deposit extends Thread {
    private Bank bank;
    public Deposit(Bank b) {
        bank = b;
    }
    public void run() {
        for(int i = 0; i < 5; i++) {
            int add = (int)(500+Math.random()*(1000-500+1));
            bank.put(add);
        }
    }
}

class Withdrawal extends Thread {
    private Bank bank;
    public Withdrawal(Bank b) {
        bank = b;
    }
    public void run() {
        for(int i = 0; i < 5; i++) {
            int minus = (int)(500+Math.random()*(1000-500+1));
            bank.get(minus);
        }
    }
}

public class TestBank {
    public static void main(String[] args) {
        Account account = new Account("李华", 0);
        Bank bank = new Bank(account.money);
        Deposit deposit = new Deposit(bank);
        Withdrawal withdrawal = new Withdrawal(bank);
        System.out.println("账户："+account.name+"  "+"银行卡初始余额："+account.money);
        deposit.start();
        withdrawal.start();
    }
}


