package pratice3;

class Sell2 {
    private int no = 0;
    private int num;
    public int selling(String name, int i) {
        num = i;
        if(no < num) {
            no++;
            System.out.println(name+": 售卖出第"+no+"张车票。");
            return no;
        } else {
            System.out.println(name+"票已售完!");
            return num + 1;
        }
    }
}

class tickets2 extends Thread {
    private Sell sell;
    private String name;
    private int tickets = 10;
    public tickets2(Sell s, String name){
        sell = s;
        this.name = name;
    }
    public void run() {
        int num;
        int flag = 1;
        while(flag <= tickets) {
            flag = sell.selling(name,tickets);

            //try {
                //sleep((int)(Math.random()*100));
            //} catch (InterruptedException e) {}
        }
    }
}

public class TestTrain2 {
    public static void main(String[] args) {
        Sell sell = new Sell();
        tickets t1 = new tickets(sell, "售票窗口1");
        tickets t2 = new tickets(sell, "售票窗口2");
        tickets t3 = new tickets(sell, "售票窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}


