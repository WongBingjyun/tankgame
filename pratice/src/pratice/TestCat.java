package pratice;

class Cat{
    public Cat(){
        System.out.println("这里没有小猫。");
    }
    public Cat(int sum){
        System.out.println("这里有" + sum + "只小猫。");
    }
}

public class TestCat {
    public static void main(String[] args) {
        Cat cat1 = new Cat();
        Cat cat2 = new Cat(3);
    }
}
