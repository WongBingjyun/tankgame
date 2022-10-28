package pratice4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Count2 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入要统计的文件名：");
        String name = in.nextLine();
        File file = new File(name);
        Scanner s = new Scanner(file);
        while(s.hasNext()) {
            String str = s.nextLine();
            char chs[] = str.toCharArray();
            int count = 0;
            System.out.println("各字母个数统计：");
            for (char ch = 'a'; ch < 'z'; ch++) {
                count = 0;
                for (int i = 0; i < chs.length; i++) {
                    if (ch == chs[i])
                        count++;
                }
                if (count != 0) {
                    System.out.println(ch + ":" + count + "个");
                }
            }
            for (char ch = 'A'; ch < 'Z'; ch++) {
                count = 0;
                for (int i = 0; i < chs.length; i++) {
                    if (ch == chs[i])
                        count++;
                }
                if (count != 0) {
                    System.out.println(ch + ":" + count + "个");
                }
            }
        }
    }
}
