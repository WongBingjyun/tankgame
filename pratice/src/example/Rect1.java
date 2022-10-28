package example;

//类和对象
public class Rect1 {
    float getPeri(float w, float h){
        float a;
        a = 2 * (w + h);
        return a;
    }
    public static void main(String[] args){
        Rect1 rect1 = new Rect1();
        System.out.println("The perimeter is :" + rect1.getPeri(4.0f, 5.0f));
    }
}
