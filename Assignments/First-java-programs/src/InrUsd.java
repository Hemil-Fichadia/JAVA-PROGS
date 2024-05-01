import java.util.Scanner;

public class InrUsd {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter amount in INR: ");
        float inr = input.nextFloat();
        System.out.println("INR to USD amount: "+ inr*0.013);
    }
}
