package pratice4;

import java.io.*;

public class Read2 {
    public static void main(String[] args) throws IOException {
        BufferedReader brin = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pout = new PrintWriter(new FileWriter("Read2.txt"));
        String s;
        System.out.println("请按行输入字符串，输入'quit'结束：");
        while (!(s = brin.readLine()).equals("quit")) {
            pout.println(s);
        }
        brin.close();
        pout.close();
    }
}
