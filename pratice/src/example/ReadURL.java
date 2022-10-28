package example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class ReadURL {
    public static void main(String[] args) {
        try{
            URL myurl = new URL("http://english.gdut.edu.cn/");
            BufferedReader dis = new BufferedReader(new InputStreamReader(myurl.openStream()));

            String inL;
            while ((inL = dis.readLine()) != null) {
                System.out.println(inL);
            }
            dis.close();
        } catch (MalformedURLException me) {
            System.out.println("MalfoomedURLException:" + me);
        } catch (IOException ioe) {
            System.out.println("IOException:" + ioe);
        }
    }
}
