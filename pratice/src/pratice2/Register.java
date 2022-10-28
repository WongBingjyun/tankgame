package pratice2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register {
    public static void main(String[] args){
        Pattern p = null;
        Matcher m = null;
        boolean flag = false;
        Scanner scan = new Scanner(System.in);

        System.out.println("-----网页注册-----");
        System.out.print("姓名：");
        String name = scan.nextLine();
        while(!flag) {
            System.out.print("手机号码：");
            String number = scan.nextLine();
            p = Pattern.compile("^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\\d{8}$");
            m = p.matcher(number);
            flag = m.matches();
            if(flag == false){
                System.out.println("格式错误！");
            }
        }
        flag = false;
        while(!flag) {
            System.out.print("邮件：");
            String email = scan.nextLine();
            p = Pattern.compile("^([A-Za-z0-9_\\-.])+@([A-Za-z0-9_\\-.])+.([A-Za-z]{2,4})$");
            m = p.matcher(email);
            flag = m.matches();
            if(flag == false){
                System.out.println("格式错误！");
            }
        }
        flag = false;
        while(!flag) {
            System.out.print("身份证号：");
            String ID = scan.nextLine();
            p = Pattern.compile("^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$");
            m = p.matcher(ID);
            flag = m.matches();
            if(flag == false){
                System.out.println("格式错误！");
            }
        }
        System.out.println("注册成功！");
    }
}
