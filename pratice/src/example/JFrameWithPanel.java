package example;


import java.awt.*;
import javax.swing.*;

public class JFrameWithPanel {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Frame With Panel");
        Container contentPane = frame.getContentPane();
        contentPane.setBackground(Color.CYAN); // 将JFrame实例背景设置为蓝绿色
        JPanel panel = new JPanel(); // 创建一个JPanel的实例
        JPanel panel1 = new JPanel(); // 创建一个JPanel的实例
        JPanel panel2 = new JPanel(); // 创建一个JPanel的实例
        panel1.setBackground(Color.RED);
        panel1.setPreferredSize(new Dimension(300, 150));
        panel2.setBackground(Color.BLUE);
        panel.setBackground(Color.yellow); // 将JPanel的实例背景设置为黄色
        JButton button = new JButton("Press me");
        panel.add(button); // 将JButton实例添加到JPanel中
        contentPane.add(panel1, BorderLayout.NORTH);
        contentPane.add(panel, BorderLayout.CENTER); // 将JPanel实例添加到JFrame的南侧
        contentPane.add(panel2, BorderLayout.SOUTH);
        frame.setSize(400, 600);
        frame.setVisible(true);
    }
}