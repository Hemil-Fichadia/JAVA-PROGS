public class SquareRoot {
    public static void main(String[] args) {
        /*Writing the logic of square root */
        int num = 11;
        int ans = findSQRT(num);
        System.out.println(ans);
    }

    static int findSQRT(int num) {

        if(num == 0 || num == 1){
            return num;
        }

        /*Starting from 1 try all numbers until i*i is greater than or equal to the num.*/

        int i = 1, result = 1;

        while(result <= num){
            i++;
            result = i * i;
        }
        return i - 1;
    }
}
