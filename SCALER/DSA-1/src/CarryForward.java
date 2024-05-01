public class CarryForward {
    public static void main(String[] args) {
//        int[] A = {2, 3, -1, 4, 2, 1};
//        System.out.println(pickFromBothSides(A, 4));

        int[] A = {2, 3, 4, 3, 4, 4, 1};
        System.out.println(pickFromBothSides(A, 6));
    }

    public static int pickFromBothSides(int[] A, int B) {
        int sum = 0;
        int maxSum = 0;
        int n = A.length;

        for(int left = 0; left <= B; left++){
            System.out.print(left);
            System.out.println("//////////////////////////////////////////");
            sum = 0;

            for(int i = 0; i < left; i++){
                System.out.print(A[i]);
                System.out.println("################################");
                sum += A[i];
            }

            for(int j = n-1-B+1 +left; j < n; j++){
                System.out.print(A[j]);
                System.out.println("********************************");
                sum += A[j];
            }

            if(maxSum < sum){
                maxSum = sum;
            }
            System.out.println();
        }
        return maxSum;
    }
}
