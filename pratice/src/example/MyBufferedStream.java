package example;

import java.io.*;

public class MyBufferedStream {
    public static void main(String[] args) {
        File file = new File(".\\src\\"+"buffer.txt");
        try (BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(file));
        BufferedInputStream fis = new BufferedInputStream(new FileInputStream(file))) {
            fos.write("My Java Program!".getBytes());
            fos.flush();
            byte[] buf = new byte[50];
            int len = fis.read(buf);
            System.out.println(new String(buf, 0, len));
        } catch (FileNotFoundException e) {
            e.getMessage();
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
