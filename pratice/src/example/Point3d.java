package example;

public class Point3d extends Point{
    int z;
    Point3d(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }
    double distance(int x, int y, int z){
        int dx = this.x - x;
        int dy = this.y - y;
        int dz = this.z - z;
        return Math.sqrt(dx*dx + dy*dy + dz*dz);
    }
    double distance(Point3d other) {
        return distance(other.x, other.y, other.z);
    }
    double distance(int x, int y){
        double dx = (this.x/2) - x;
        double dy = (this.y/2) - y;
        return Math.sqrt(dx*dx + dy*dy);
    }
}
class Point3ddist{
    public static void main(String[] args){                                                                                                                                                                                                                                                                                                                                                                                                                                          
        Point3d p1 = new Point3d(30,40,10);
        Point3d p2 = new Point3d(0,0,0);
        Point p = new Point(0,0);
        System.out.println("p1="+p1.x+","+p1.y+","+p1.z);
        System.out.println("p2="+p2.x+","+p2.y+","+p2.z);
        System.out.println("p="+p.x+","+p.y);
        System.out.println("p1.distance(p2)="+p1.distance(p2));
        System.out.println("p1.distance(3,4)="+p1.distance(3,4));
        System.out.println("p.distance(3,4)="+p.distance(3,4));
    }
}
