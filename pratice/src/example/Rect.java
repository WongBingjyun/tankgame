package example;

//构造方法
public class Rect {
    protected float width, height;
    public float area;
    public Rect(float w, float h){
        width = w;
        height = h;
        area = getArea(w, h);
    }
    public float getArea(float w, float h){
        float a;
        a = w * h;
        return a;
    }
}

class MyRect{
    public static void main(String[] args){
        Rect rect = new Rect(4.0f, 6.0f);
        System.out.println("The area is :" + rect.area);
    }
}
