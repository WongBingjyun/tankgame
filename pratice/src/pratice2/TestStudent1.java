package pratice2;

interface Student1{
    double scholarship(double GPA, double bonus);
}

public class TestStudent1 {
    static void scholarship(double grade) {
        if(grade >= 90){
            System.out.println("奖学金等级为A");
        }
        else if(grade >= 80){
            System.out.println("奖学金等级为B");
        }
        else if(grade >= 70){
            System.out.println("奖学金等级为C");
        }
        else{
            System.out.println("无奖学金");
        }
    }
    public static void main(String[] args){
        Student1 Undergraduate = (double GPA, double bonus)->((GPA * 20) * 0.6) + bonus * 0.4;
        Student1 Postgraduate = (double GPA, double bonus)->((GPA * 20) * 0.8) + bonus * 0.2;
        scholarship(Undergraduate.scholarship(4.7,75));
        scholarship(Postgraduate.scholarship(4.7,75));
    }
}
