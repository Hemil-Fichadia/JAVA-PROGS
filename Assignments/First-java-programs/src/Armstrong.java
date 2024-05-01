import java.util.Scanner;

public class Armstrong {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = input.nextInt();

        int numcheck = num;
        int num2;
        int sum = 0;
        int rednum = num;
        int len = 0;
        while(num > 0)
        {
            num = num / 10;
            len++;
        }
//        System.out.println("Length: "+len);
        while(numcheck > 0)
        {
            num2 = numcheck % 10;
            sum = (int) (sum + Math.pow(num2,len));
            numcheck = numcheck / 10;

        }
//        System.out.println("Sum "+sum);
        if(rednum == sum)
        {
            System.out.println(rednum+" is an Armstrong number");
        }
        else
        {
            System.out.println(rednum+" is not an Armstrong number");
        }

    }
}
