package pratice2;

interface Student2{
    void scholarship(scholarship sc);
}

class scholarship{
    double GPA, bonus;
    scholarship(double GPA1, double bonus1){
        GPA = GPA1;
        bonus = bonus1;
    }
    void Undergraduate() {
        double grade;
        grade = ((GPA * 20) * 0.6) + bonus * 0.4;
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
    void Postgraduate() {
        double grade;
        grade = ((GPA * 20) * 0.8) + bonus * 0.2;
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
}

public class TestStudent2 {
    public static void main(String[] args) {
        scholarship sc = new scholarship(4.7, 75);
        Student2 student1 = scholarship::Undergraduate;
        student1.scholarship(sc);
        Student2 student2 = scholarship::Postgraduate;
        student2.scholarship(sc);
    }
}
