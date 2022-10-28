package pratice2;

class Figure{
    double length;
    public Figure(double length) {
        this.length = length;
    }
    double Area() {
        double Area;
        Area = length * length;
        return Area;
    }
}

class Triangle extends Figure {
    double height;
    public Triangle(double hemline, double height) {
        super(hemline);
        this.height = height;
    }
    double Area() {
        double Area;
        Area = (length * height)/2;
        return Area;
    }
}

class Rectangle extends Figure {
    double width;
    public Rectangle(double length, double width) {
        super(length);
        this.width = width;
    }
    double Area() {
        double Area;
        Area = length * width;
        return Area;
    }
}

public class TestFigure {
    public static void main(String[] args){
        Triangle triangle = new Triangle(5,4);
        Rectangle rectangle = new Rectangle(5,4);
        double Area;
        Area = triangle.Area();
        System.out.println(Area);
        Area = rectangle.Area();
        System.out.println(Area);
    }
}
