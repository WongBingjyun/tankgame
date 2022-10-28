package pratice2;

abstract class Student{
    String number;
    String name;
    double GPA;
    double bonus;
    abstract void scholarship(String number, String name, double GPA, double bonus);
}

class Undergraduate extends Student{
    void scholarship(String number, String name, double GPA, double bonus) {
        double grade;
        grade = ((GPA * 20) * 0.6) + bonus * 0.4;
        if(grade >= 90){
            System.out.println(name + "的奖学金等级为A");
        }
        else if(grade >= 80){
            System.out.println(name + "的奖学金等级为B");
        }
        else if(grade >= 70){
            System.out.println(name + "的奖学金等级为C");
        }
        else{
            System.out.println(name + "无奖学金");
        }
    }
}

class Postgraduate extends Student{
    void scholarship(String number, String name, double GPA, double bonus) {
        double grade;
        grade = ((GPA * 20) * 0.8) + bonus * 0.2;
        if(grade >= 90){
            System.out.println(name + "的奖学金等级为A");
        }
        else if(grade >= 80){
            System.out.println(name + "的奖学金等级为B");
        }
        else if(grade >= 70){
            System.out.println(name + "的奖学金等级为C");
        }
        else{
            System.out.println(name + "无奖学金");
        }
    }
}

public class TestStudent {
    public static void main(String[] args){
        Student[] student = new Student[4];
        student[0] = new Undergraduate();
        student[1] = new Postgraduate();
        student[2] = new Undergraduate();
        student[3] = new Postgraduate();
        student[0].scholarship("1","小明",4.7,75);
        student[1].scholarship("2","小华",4.7,75);
        student[2].scholarship("3","小红",4.0,90);
        student[3].scholarship("4","小丽",4.0,90);
    }
}
