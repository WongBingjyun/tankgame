package example;

interface  Bike{
    public final boolean isPublic = true;
    public float Charge(float h);
    public String getBikeName();
}

class Mobike implements Bike {
    public float Charge(float h){
        return 2*h;
    }

    public String getBikeName() {
        return "摩拜单车";
    }
}

class Ofo implements Bike{
    public float Charge(float h){
        return 1*h;
    }
    public String getBikeName(){
        return "小黄车";
    }
}

public class UseBike {
    public static void main(String[] args){
        Bike[] b = new Bike[2];
        b[0] = new Mobike();
        b[1] = new Ofo();
        for(Bike bik: b){
            System.out.println(bik.getBikeName());
            System.out.println(bik.Charge(4));
        }
    }
}
