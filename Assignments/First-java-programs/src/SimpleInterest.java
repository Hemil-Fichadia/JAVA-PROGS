import java.util.Scanner;

public class SimpleInterest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Principle amount: ");
        float p = input.nextFloat();
        System.out.print("Enter time duration: ");
        int t = input.nextInt();
        System.out.print("Enter rate of interest: ");
        float r = input.nextFloat();

        float simpleinterest = (p * r * t) / 100;

        System.out.println("Interest calculated is: "+ simpleinterest);
    }
}
