package example;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;

import javax.swing.text.JTextComponent;

import javax.swing.JTextField;

import javax.swing.JButton;

import javax.swing.SwingConstants;

import java.awt.Color;

import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;

import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;

import java.io.OutputStreamWriter;

import java.io.PrintWriter;

import java.net.InetAddress;

import java.net.ServerSocket;

import java.net.Socket;

import java.net.UnknownHostException;

import java.util.ArrayList;

import java.util.Scanner;

import javax.swing.JTextArea;

public class jxc extends JFrame {

    private JPanel contentPane;

    private JTextField textField;

    private JTextField textField_1;

    private JTextField textField_2;

    private static PrintWriter pw=null;

    private static BufferedReader br=null;

    private static Socket s;

    static Scanner scanner=new Scanner(System.in);

    private JTextField textField_3;

    /**

     * Launch the application.

     */

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            public void run() {

                try {

                    jxc frame = new jxc();

                    frame.setVisible(true);

                } catch (Exception e) {

                    e.printStackTrace();

                }

            }

        });

    }

    /**

     * Create the frame.

     */

    public jxc() {

        setTitle("\u804A\u5929\u5BA4");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setBounds(100, 100, 770, 412);

        contentPane = new JPanel();

        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);

        contentPane.setLayout(null);

        JButton btnNewButton = new JButton("\u53D1\u9001");

        btnNewButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {

                try {

                    pw=new PrintWriter(new OutputStreamWriter(s.getOutputStream()));

                    br=new BufferedReader(new InputStreamReader(s.getInputStream()));

                    ArrayList list= new ArrayList();

                    list.add("我叫杨朋超");

                    list.add(11);

                    list.add('w');

                    String str = textField_1.getText();

                    textField_1.setText("");

                    pw.println(str+list);

                    pw.flush();

                    String string=br.readLine();

                    textField.setText(textField.getText()+"\n"+string);

                } catch (IOException e) {

// TODO Auto-generated catch block

                    e.printStackTrace();

                }

            }

        });

        textField = new JTextField();

        textField.setBounds(10, 10, 529, 186);

        contentPane.add(textField);

        textField.setColumns(10);

        btnNewButton.setBounds(31, 329, 93, 23);

        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("\u53D6\u6D88");

        btnNewButton_1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {

                String  str= "";

                textField_1.setText(str);

            }

        });

        btnNewButton_1.setBounds(153, 329, 93, 23);

        contentPane.add(btnNewButton_1);

        textField_1 = new JTextField();

        textField_1.setBounds(10, 217, 529, 102);

        contentPane.add(textField_1);

        textField_1.setColumns(10);

        textField_2 = new JTextField();

        textField_2.setBounds(549, 229, 154, 23);

        contentPane.add(textField_2);

        textField_2.setColumns(10);

        JButton btnNewButton_2 = new JButton("\u8FDE\u63A5");

        btnNewButton_2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                try {

                    s=new Socket(textField_2.getText(),Integer.parseInt(textField_3.getText()));

                } catch (NumberFormatException | IOException e1) {

// TODO Auto-generated catch block

                    e1.printStackTrace();

                }

            }

        });

        btnNewButton_2.setBounds(549, 296, 93, 23);

        contentPane.add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("IP");

        btnNewButton_3.setBounds(549, 196, 93, 23);

        contentPane.add(btnNewButton_3);

        JTextArea textArea = new JTextArea();

        textArea.setBounds(638, 124, 4, 24);

        contentPane.add(textArea);

        textField_3 = new JTextField();

        textField_3.setBounds(549, 262, 66, 21);

        contentPane.add(textField_3);

        textField_3.setColumns(10);

    }

}
