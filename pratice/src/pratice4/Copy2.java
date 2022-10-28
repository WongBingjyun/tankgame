package pratice4;

import java.io.*;
import java.util.Scanner;

public class Copy2 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入要复制的文件名：");
        String name1 = in.nextLine();
        System.out.println("请输入目标文件名");
        String name2 = in.nextLine();
        BufferedReader brin = new BufferedReader(new FileReader(name1));
        BufferedWriter brout = new BufferedWriter(new FileWriter(name2));
        String s;
        while((s = brin.readLine()) != null) {
            brout.write(s);
            brout.newLine();
        }
        brout.flush();
        brin.close();
        brout.close();
    }
}
