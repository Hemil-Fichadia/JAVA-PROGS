public class MatrixMultiplication {
    public static void main(String[] args) {
        int[][] A = {
                {1, 2, 3},
                {4, 5, 6}
        };
        int[][] B = {
                {1, 3, 5},
                {7, 9, 2},
                {4, 6, 8}
        };
        int Bcols = 3;
        int[][] ans = new int[A.length][B[0].length];
        for(int row = 0; row < A.length; row++){

            //For rows of first matrix
            int[] rowArr = new int[A[row].length];

            for(int col = 0; col < A[row].length; col++){
                rowArr[col] = A[row][col];
                System.out.println(rowArr[col]);
            }
            System.out.println("*********************************");
            //for cols of secondmatrix
            for(int Bcol = 0; Bcol < Bcols; Bcol++){
                int sum = 0;
                System.out.println("///////////////////////////////////////");
                for(int Brow = 0; Brow < B.length; Brow++){
                    sum += rowArr[Brow] * B[Brow][Bcol];
                    System.out.println("rowArr : "+rowArr[Brow]+" Maix B : "+B[Brow][Bcol]+" sum : "+sum);
                }
                ans[row][Bcol] = sum;
                //System.out.println(sum);
            }
            System.out.println("----------------------------------------------------");
        }

        System.out.println("Printing the answer");
        for (int row = 0; row < ans.length; row++) {
            for (int col = 0; col < ans[row].length; col++) {
                System.out.print(ans[row][col]+" ");
            }
            System.out.println();
        }
    }
}
