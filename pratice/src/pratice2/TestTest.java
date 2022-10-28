package pratice2;

interface if1 {
    void cat();
    void dog();
}

interface if2 {
    void bird();
    void fish();
}

class cl {
    void animals(){
        System.out.println("These are animals.");
    }
}

interface if3 extends if1, if2 {
    void tiger();
}

class Test extends cl implements if3 {
    public void cat() {
        System.out.println("This is a cat.");
    }

    public void dog() {
        System.out.println("This is a dog.");
    }

    public void bird() {
        System.out.println("This is a bird.");
    }

    public void fish() {
        System.out.println("This is a fish.");
    }

    public void tiger() {
        System.out.println("This is a tiger.");
    }
}

public class TestTest {
    public static void main(String[] args){
        Test test = new Test();
        test.animals();
        test.bird();
        test.cat();
        test.dog();
        test.fish();
        test.tiger();
    }
}
