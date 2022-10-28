package example;

//方法重载
public class Point {
    int x, y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    double distance(int x, int y){
        int dx = this.x - x;
        int dy = this.y - y;
        return Math.sqrt(dx*dx + dy*dy);
    }
    double distance(Point p){
        return distance(p.x, p.y);
    }
}
class myPoint{
    public static void main(String[] args){
        Point p1 = new Point(2, 3);
        Point p2 = new Point(3, 5);
        System.out.println("p1到二维坐标原点的距离是：" + p1.distance(0,0));
        System.out.println("p1到p2的距离是：" + p1.distance(p2));
    }
}
