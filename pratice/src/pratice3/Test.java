package pratice3;

class Ticket {
    //字符串数组中存储每张票的名称
    private String[] tickets;
    //初始时总票数
    private int initialTicketNumber;
    //卖出车票的数量，初始化时为0
    private int sellOutTickets;

    //setter不可提供，总票数在最开始时便以确定不可更改，字符串数组在构造方法中有，也不可更改

    public String[] getTickets() {
        return tickets;
    }

    public int getInitialTicketNumber() {
        return initialTicketNumber;
    }

    public Ticket(int initialTicketNumber) {
        this.tickets = new String[initialTicketNumber];
        this.initialTicketNumber = initialTicketNumber;
    }

    public Ticket() {
        this(200);
    }


    //初始化票
    public void initializeTickets(){
        for (int i = 0; i < tickets.length; i++) {
            tickets[i] = (i+1) + "号车票";
        }
    }


    //初始化卖票的接口 saleTickets
    public synchronized String saleTickets() throws TicketsSellOutException {
        if ((initialTicketNumber - sellOutTickets) > 0){
            String ticket = tickets[sellOutTickets];
            //特意出现卖出同张车票的场景
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sellOutTickets++;
            return ticket;
        }else{
            throw new TicketsSellOutException("票已售空！");
        }
    }
}

class InitializeTicketsThread implements Runnable{
    private Ticket tickets;
    boolean run = true;

    public InitializeTicketsThread(Ticket tickets) {
        this.tickets = tickets;
    }

    public InitializeTicketsThread() {
    }

    @Override
    public void run() {
        tickets.initializeTickets();
    }
}

class SaleTicketsThread implements Runnable{
    private Ticket tickets;
    boolean run = true;

    public SaleTicketsThread() {
    }

    public SaleTicketsThread(Ticket tickets) {
        this.tickets = tickets;
    }

    @Override
    public void run() {
        while (run){
            try {
                System.out.println(Thread.currentThread().getName() +":"+ tickets.saleTickets() + "已售出！");
            } catch (TicketsSellOutException e) {
                run = false;
                e.printStackTrace();
            }
        }
    }
}

class TicketsSellOutException extends Exception {
    public TicketsSellOutException() {
    }

    public TicketsSellOutException(String message) {
        super(message);
    }
}

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Ticket tickets = new Ticket(10);
        Thread t0 = new Thread(new InitializeTicketsThread(tickets));
        t0.setName("初始化车票");
        t0.start();
        //抛出异常，若车票尚未初始化完成，不可售票！
        //等到t0线程完成，才可继续执行main线程
        t0.join();
        Thread t1 = new Thread(new SaleTicketsThread(tickets));
        t1.setName("售票窗口1");
        t1.start();

        Thread t2 = new Thread(new SaleTicketsThread(tickets));
        t2.setName("售票窗口2");
        t2.start();

        Thread t3 = new Thread(new SaleTicketsThread(tickets));
        t3.setName("售票窗口3");
        t3.start();
        Thread t4 = new Thread(new SaleTicketsThread(tickets));
        t4.setName("售票窗口4");
        t4.start();
    }
}

