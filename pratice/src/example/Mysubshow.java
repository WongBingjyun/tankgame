package example;

//方法重写
class Myclass{
    boolean op1;
    void Mymethod(){
        op1 = true;
    }
}
class Mysub extends Myclass{
    boolean op1;
    void Mymethod(){
        op1 = false;
        super.Mymethod();
        System.out.println(op1);
        System.out.println(super.op1);
    }
}
public class Mysubshow {
    public static void main(String[] args){
        Mysub mysub = new Mysub();
        mysub.Mymethod();
    }
}
