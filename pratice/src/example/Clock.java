package example;

import java.applet.Applet;
import java.awt.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Clock extends Applet implements Runnable {
    private static final long serialVersionUID = 1L;
    Thread clockThread;
    public void start() {
        if (clockThread == null) {
            clockThread = new Thread(this,"Clock");
            clockThread.start();
        }
    }
    public void run() {
        while (clockThread != null) {
            repaint();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public void paint(Graphics g) {
        Calendar now = new GregorianCalendar();
        g.drawString(now.get(Calendar.HOUR_OF_DAY)+":"+now.get(Calendar.MINUTE)+":"+now.get(Calendar.SECOND),5,10);
    }
}
