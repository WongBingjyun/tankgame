package example;

class pThread extends Thread {
    String name;
    public pThread(String str){
        name = str;
    }
    public void run(){
        for(int i = 0; i < 2; i++){
            System.out.println(name+": "+getPriority());
        }
    }
}

public class myPriority {
    public static void main(String[] args) {
        pThread Th1 = new pThread("Win");
        Th1.setPriority(Thread.MIN_PRIORITY);
        Th1.start();

        pThread Th2 = new pThread("Lost");
        Th2.setPriority(Thread.MAX_PRIORITY);
        Th2.start();

        pThread Th3 = new pThread("Once more");
        Th3.setPriority(Thread.NORM_PRIORITY);
        Th3.start();
    }
}
