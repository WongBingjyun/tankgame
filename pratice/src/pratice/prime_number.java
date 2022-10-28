package pratice;

public class prime_number {
    public static void main(String args[]){
        int sum = 0;
        for(int i = 2; i <= 100; i++) {
            boolean flag = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag == true) {
                System.out.print(i + " ");
                sum+=i;
            }
        }
        System.out.println(sum);
    }
}
