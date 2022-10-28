package pratice;

class Rectangle{
    double width;
    double height;
    public Rectangle(double w, double h){
        width = w;
        height = h;
    }
    double getArea(){
        double Area;
        Area = width * height;
        return Area;
    }
    double getPerimeter(){
        double Perimeter;
        Perimeter = 2 * (width + height);
        return Perimeter;
    }
    void Draw(){
        for(int i = 0; i < width; i++){
            System.out.print("******");
        }
        for(int i = 0; i < (height * 3) - (height - 1) - 2; i++){
            System.out.print("\n");
            System.out.print("*");
            for(int j = 0; j < (width * 6) - 2; j++){
                System.out.print(" ");
            }
            System.out.print("*");
        }
        System.out.print("\n");
        for(int i = 0; i < width; i++){
            System.out.print("******");
        }
    }
}

public class TestRectangle {
    public static void main(String[] args){
        Rectangle rectangle = new Rectangle(5,4);
        double Area = rectangle.getArea();
        double Perimeter = rectangle.getPerimeter();
        System.out.println("矩形面积为：" + Area + "cm²");
        System.out.println("矩形周长为：" + Perimeter + "cm");
        rectangle.Draw();
    }
}
