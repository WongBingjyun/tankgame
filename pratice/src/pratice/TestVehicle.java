package pratice;

class Vehicle{
    String name;
    int speed;
    int price;
    public Vehicle(String name, int speed, int price){
        this.name = name;
        this.speed = speed;
        this.price = price;
    }
    void increase(int incremrnt){
        System.out.println("涨价" + incremrnt + "元");
        this.price = this.price + incremrnt;
    }
    void decrease(int decrement){
        System.out.println("降价" + decrement + "元");
        this.price = this.price - decrement;
    }
}

public class TestVehicle {
    public static void main(String[] args){
        Vehicle vehicle = new Vehicle("McLaren",300,5000000);
        System.out.println("名称：" + vehicle.name + "\n" + "速度：" + vehicle.speed + "km/h" + "\n" + "价格：" + vehicle.price + "元");
        vehicle.increase(50000);
        System.out.println("名称：" + vehicle.name + "\n" + "速度：" + vehicle.speed + "km/h" + "\n" + "价格：" + vehicle.price + "元");
        vehicle.decrease(20000);
        System.out.println("名称：" + vehicle.name + "\n" + "速度：" + vehicle.speed + "km/h" + "\n" + "价格：" + vehicle.price + "元");
    }
}
