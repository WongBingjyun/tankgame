package pratice4;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Delete2 {
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
            List list = new ArrayList();
            list.add(s);
            Iterator<String> it = list.iterator();
            while(it.hasNext()){
                String x = it.next();
                System.out.println("删除前的字符串为："+it);
                if(x.equals("stuff")){
                    it.remove();
                }
                System.out.println("删除后的字符串为："+it);
            }
            brout.write(it.toString());
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
