package pratice4;

import java.io.*;
import java.util.Scanner;

public class Count1 {
    public static void main(String[] args) throws IOException {
        int count_char = 0;
        int count_word = 0;
        int count_line = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("请输入要统计的文件名：");
        String name = in.nextLine();
        File file = new File(name);
        Scanner s = new Scanner(file);
        while(s.hasNext()) {
            String str = s.nextLine();
            count_char += str.length();
            Scanner sc = new Scanner(str);
            while(sc.hasNext()) {
                sc.next();
                count_word++;
            }
            count_line++;
        }
        System.out.println("字符数："+count_char);
        System.out.println("单词数："+count_word);
        System.out.println("行数："+count_line);
    }
}
