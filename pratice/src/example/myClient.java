package example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.Buffer;

public class myClient {
    public static void main(String[] args) {
        try{
            Socket mysocket = new Socket(InetAddress.getLocalHost(), 1234);
            BufferedReader is = new BufferedReader(new InputStreamReader(mysocket.getInputStream()));
            PrintWriter os = new PrintWriter(mysocket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("客户端...");
            while (true) {
                String str = in.readLine();
                os.println(str);
                os.flush();
                if(str.equals("bye")) {
                    break;
                }
                System.out.println("对方发来："+is.readLine());
            }
            is.close();
            os.close();
            mysocket.close();
        } catch (IOException e) {
            System.out.println("Could not connect the server!");
            System.exit(1);
        }
    }
}
