import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner input =  new Scanner(System.in);

        System.out.print("Enter a number: ");
        float num1 = input.nextFloat();
        System.out.print("Enter another number: ");
        float num2 = input.nextFloat();

        System.out.print("Enter any of the operator + - * / %: ");
        String op = input.next();
        if(op.equals("+"))
        {
            float sum = num1 + num2;
            System.out.println("Sum of numbers: "+ sum);
        }
        else if(op.equals("-"))
        {
            float sum = num1 - num2;
            System.out.println("Subtraction of numbers: "+ sum);
        }
        else if(op.equals("*"))
        {
            float sum = num1 * num2;
            System.out.println("Multiplication of numbers: "+ sum);
        }
        else if(op.equals("/"))
        {
            if(num2 != 0)
            {
                float sum = num1 / num2;
                System.out.println("Division of numbers: "+ sum);
            }
            else
            {
                System.out.println("Cannot divide by zero");
            }
        }
        else if(op.equals("%"))
        {
            float sum = num1 % num2;
            System.out.println("Remainder: "+ sum);
        }
        else
        {
            System.out.println("Invalid operation");
        }
    }
}
