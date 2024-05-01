import java.util.Locale;
import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String palindrome = input.next().toLowerCase();
        StringBuffer rev = new StringBuffer(palindrome);
        rev.reverse();
        String rev1 = rev.toString();
        if (rev1.equals(palindrome))
        {
            System.out.println("It is a palindrome string");
        }
        else
        {
            System.out.println("It is not a palindrome string");
        }

    }
}
