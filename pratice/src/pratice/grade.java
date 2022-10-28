package pratice;

import java.util.Scanner;

public class grade {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int score = scanner.nextInt();
        if(0 <= score && score <= 59){
            System.out.println("Your grade is fail.");
        }
        else if(60 <= score && score <= 79){
            System.out.println("Your grade is pass.");
        }
        else if(80 <= score && score <= 89){
            System.out.println("Your grade is good.");
        }
        else if(90 <= score && score <= 100){
            System.out.println("Your grade is excellent good.");
        }
        else{
            System.out.println("Invalid grade.");
        }
    }
}
