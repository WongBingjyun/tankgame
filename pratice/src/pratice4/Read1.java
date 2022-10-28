package pratice4;

import java.io.*;
import java.util.Scanner;

public class Read1 {
    public static void main(String[] args) throws IOException {
        BufferedReader brin = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter brout = new BufferedWriter(new FileWriter("Read1.txt"));
        String s;
        System.out.println("请按行输入字符串，输入'quit'结束：");
        while (!(s = brin.readLine()).equals("quit")) {
            brout.write(s);
            brout.newLine();
        }
        brout.flush();
        brin.close();
        brout.close();
    }
}
