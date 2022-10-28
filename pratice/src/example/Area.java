package example;

abstract class Figure{
    abstract int getArea(int v, int h);
}

class Rectangle extends Figure{
    int getArea(int w, int h){
        return w * h;
    }
}

class Triangle extends Figure{
    int getArea(int w, int h){
        return (w * h) / 2;
    }
}

public class Area {
    public static void main(String[] args){
        Figure[] f = new Figure[2];
        f[0] = new Rectangle();
        f[1] = new Triangle();
        for(Figure fig : f)
            System.out.println(fig.getArea(4,5));
    }
}
