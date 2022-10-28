package example;

public class ExcepTest {
    public static void main(String[] args) {
        try{
            int a[] = new int[2];
            System.out.println("Access element three :" + a[3]);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Exception thrown  :" + e.getMessage());
        }
        System.out.println("Out of the block");
    }
}
