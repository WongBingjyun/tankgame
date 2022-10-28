package example;

public class Rect2 {
    class Rect3{
        public int getArea(int w, int h){
            int a;
            a = w * h;
            return a;
        }
    }
    class Rect4{
        int getPeri(int w, int h){
            int a;
            a = 2 * (w + h);
            return a;
        }
    }
    public static void main(String[] args){
        Rect2 rect2 = new Rect2();
        Rect3 rect3 = rect2.new Rect3();
        Rect4 rect4 = rect2.new Rect4();
        System.out.println("The area is:" + rect3.getArea(3,4));
        System.out.println("The perimeter is:" + rect4.getPeri(4,5));
    }
}
