package pratice;

import java.util.Random;

public class random {
    public static void main(String args[]) {
        Random random = new Random();
        int A[] = new int[3];
        A[0] = random.nextInt(101);
        A[1] = random.nextInt(101);
        A[2] = random.nextInt(101);
        for(int i : A){
            System.out.println(i);
        }
        int max = A[0];
        int min = A[0];
        for(int i : A){
            if(max < i){
                max = i;
            }
            if(min > i){
                min = i;
            }
        }
        System.out.println("max is " + max);
        System.out.println("min is " + min);
    }
}
