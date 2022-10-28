package pratice4;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;

public class Delete1 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入文件名：");
        String srcName = in.nextLine();
        System.out.println("请输入要删除的内容：");
        String stuff = in.nextLine();
        BufferedReader brin = new BufferedReader(new FileReader(srcName));
        BufferedWriter brout = new BufferedWriter(new FileWriter("Delete.txt"));
        BufferedReader brin2 = new BufferedReader(new FileReader("Delete.txt"));
        String s;
        while ((s = brin.readLine()) != null) {
            StringBuilder sb = new StringBuilder(s);
            System.out.println("删除前的字符串为："+sb);
            int k;
            if((k = sb.indexOf(stuff)) != -1) {
                sb.delete(k, k + stuff.length());
            }
            System.out.println("删除后的字符串为："+sb);
            brout.write(sb.toString());
            brout.newLine();
        }
        brout.flush();
        brin.close();
        brout.close();
        BufferedWriter brout2 = new BufferedWriter(new FileWriter(srcName));
        while((s = brin2.readLine()) != null) {
            brout2.write(s);
            brout2.newLine();
        }
        brout2.flush();
        brin2.close();
        brout2.close();
    }
}
