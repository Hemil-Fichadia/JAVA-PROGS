package ExceptionHandling;

import java.util.Scanner;

public class DivisionDemo {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        /* Try and experiment all the possible exceptions in this scenario, like divide by 0,
        InputMismatch etc.
        * */
        int a = input.nextInt();
        int b = input.nextInt();

        System.out.println(a / b);
    }
}
