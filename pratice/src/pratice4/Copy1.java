package pratice4;

import java.io.*;
import java.util.Scanner;

public class Copy1 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入要复制的文件名：");
        //Copy.txt
        String name1 = in.nextLine();
        System.out.println("请输入目标文件名");
        //Copy1.txt
        String name2 = in.nextLine();
        FileInputStream fis = new FileInputStream(name1);
        FileOutputStream fos  = new FileOutputStream(name2);
        int a;
        while((a = fis.read()) != -1) {
            fos.write(a);
        }
        fis.close();
        fos.close();
    }
}
