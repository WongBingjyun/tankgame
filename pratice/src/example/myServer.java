package example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class myServer {
    public static void main(String[] args) {
        try{
            ServerSocket myserver = new ServerSocket(1234);
            Socket mysocket = myserver.accept();
            BufferedReader is = new BufferedReader(new InputStreamReader(mysocket.getInputStream()));
            PrintWriter os = new PrintWriter(mysocket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("服务器...");
            while (true) {
                String str = is.readLine();
                System.out.println("接受到："+str);
                String answerstr = in.readLine();
                os.println(answerstr);
                os.flush();
                if(str.equals("bye")) {
                    break;
                }
            }
            is.close();
            os.close();

            mysocket.close();
            myserver.close();
        } catch (IOException e) {
            System.out.println("Could not listen on port" + 1234 + "," + e);
            System.exit(1);
        }
    }
}
