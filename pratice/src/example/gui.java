package example;

import javax.swing.*;
import java.awt.*;

public class gui extends JFrame {
    public gui(String title) {
        super(title);
        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());
        Panel p = new Panel();
        p.setBackground(Color.RED);
        p.add(new Button("1"));
        p.add(new Button("2"));
        p.add(new Button("3"));
        contentPane.add(p);
        contentPane.setLayout(new FlowLayout());
        contentPane.setSize(200,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
    public static void main(String[] args) {
        new gui("文本");
    }
}

