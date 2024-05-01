public class Main {
    public static void main(String[] args) {
        //pattern2(4);
        //pattern1(4);
        //pattern3(4);
        //pattern4(4);
        //pattern5(5);
        //pattern6(5);
        //pattern7(5);
        //pattern8(5);
        //pattern8KunalMethod(5);
        //pattern5KunalMethod(5);
        //numericSquarePatternKunalMethod(4);
        //System.out.println();
        numericSquarePattern(4);

    }
/*
    4  4  4  4  4  4  4
    4  3  3  3  3  3  4
    4  3  2  2  2  3  4
    4  3  2  1  2  3  4
    4  3  2  2  2  3  4
    4  3  3  3  3  3  4
    4  4  4  4  4  4  4

    4 4 4 4 4 4 4
    4 3 3 3 3 3 4
    4 3 2 2 2 3 4
    4 3 2 1 2 3 4
    4 3 2 2 2 3 4
    4 3 3 3 3 3 4
    4 4 4 4 4 4 4

 */
    static void numericSquarePattern(int n){
        //Initialising each cell with n;
        int[][] patternArray = new int[(2*n)-1][(2*n)-1];
        for(int row = 0; row < patternArray.length; row++){
            for(int col = 0; col < patternArray[row].length; col++){
                patternArray[row][col] = n;
            }
        }

        //now manipulating the 2d array according to the values expected
        int totalRows = (2 * n) - 1;
        int left = 1;
        int right = patternArray[0].length-2;
        int mid = totalRows/2;
        /*patternArray[mid][mid] = 1;*/
        for(int row = 1; row <=mid; row++){
            for(int col = 0; col < totalRows; col++){
                if(left <= col && col <= right){
                    int digit = patternArray[row-1][col];
                    patternArray[row][col] = digit-1;
                }
                else{
                    patternArray[row][col] = patternArray[row-1][col];
                }
            }
            left++;
            right--;
        }
        //rev pattern
        /* the left and right variables are varied before the iteration of the loop as they have reached center,
           so they are to be changed to according to the next row.
        */
        for(int row = mid+1; row <= totalRows-2; row++){
            left--;
            right++;
            for(int col = 0; col < totalRows; col++){
                if(left <= col && col <= right){
                    int digit = patternArray[row-1][col];
                    patternArray[row][col] = digit+1;
                }
                else{
                    patternArray[row][col] = patternArray[row-1][col];
                }
            }
        }

        //printing th array
        System.out.println("Numeric Square Pattern by Hemil");
        for (int[] ints : patternArray) {
            for (int anInt : ints) {
                System.out.print(anInt + "  ");
            }
            System.out.println();
        }
    }
    static void numericSquarePatternKunalMethod(int n){
        int originalN = n+1;
        n = n * 2;
        for (int row = 1; row < n; row++) {
            for (int col = 1; col < n; col++) {
                int atEveryIndex = originalN-Math.min(Math.min(row, col), Math.min(n-row, n-col));
                System.out.print(atEveryIndex+"  ");
            }
            System.out.println();
        }
    }
    static void pattern8KunalMethod(int n){
        //Here kunal started from 0;
        for (int row = 0; row < 2 * n; row++) {
            // if row > n then c = 2n-row else c = row;
            int c = row > n ? 2 * n - row: row;
            for(int space = 0; space < n - c; space++){
                //In order to cover his mistake, Kunal added an extra space here.
                //So here there are two spaces, that ruins whole calculation of the pattern.
                System.out.print("  ");
            }
            for(int col = c; col >= 1; col--){
                System.out.print(col+" ");
            }
            for(int col = 2; col <= c; col++){
                System.out.print(col+" ");
            }
            System.out.println();
        }
    }
    /*
            1
          2 1 2
        3 2 1 2 3
      4 3 2 1 2 3 4
    5 4 3 2 1 2 3 4 5
      4 3 2 1 2 3 4
        3 2 1 2 3
          2 1 2
            1

    */
    static void pattern8(int n){
        int colCount = 1;
        int totalSpace = (2*n)-2;
        //Understanding the requirement, I started iterating row from 1.
        for(int row = 1; row <= n; row++){
            for(int space = 1; space <= totalSpace; space++){
                System.out.print(" ");
            }
            totalSpace -= 2;
            //variation is general counter as it reaches 1, the numbers starts increasing
            int variation = row;
            //pattern is the actual that gets printed
            int pattern = row;
            for(int col = 1; col <= colCount; col++){
                System.out.print(pattern+" ");

                if(variation > 1){
                    pattern--;
                }
                else{
                    pattern++;
                }

                variation--;
            }
            System.out.println();
            colCount += 2;
        }
        //Reverse pattern
        colCount = (2*n)-3;
        totalSpace = 2;
        for(int row = n-1; row > 0; row--){
            for(int space = 1; space <= totalSpace; space++){
                System.out.print(" ");
            }
            totalSpace += 2;
            //variation is general counter as it reaches 1, the numbers starts increasing
            int variation = row;
            //pattern is the actual that gets printed
            int pattern = row;
            for(int col = 1; col <= colCount; col++){
                System.out.print(pattern+" ");

                if(variation > 1){
                    pattern--;
                }
                else{
                    pattern++;
                }

                variation--;
            }
            System.out.println();
            colCount -= 2;
        }
    }

    /*
              1
            2 1 2
          3 2 1 2 3
        4 3 2 1 2 3 4
      5 4 3 2 1 2 3 4 5

    */
    static void pattern7(int n){

        int colCount = 1;
        int totalSpace = (2*n)-2;
        for(int row = 1; row <= n; row++){

            for(int space = 1; space <= totalSpace; space++){
                System.out.print(" ");
            }
            totalSpace -= 2;
            //variation is general counter as it reaches 1, the numbers starts increasing
            int variation = row;
            //pattern is the actual that gets printed
            int pattern = row;
            for(int col = 1; col <= colCount; col++){
                System.out.print(pattern+" ");

                if(variation > 1){
                    pattern--;
                }
                else{
                    pattern++;
                }

                variation--;
            }
            System.out.println();
            colCount += 2;
        }
    }
    /*
         *
        * *
       * * *
      * * * *
     * * * * *
      * * * *
       * * *
        * *
         *

     */
    static void pattern6(int n){
        int star = 1;
        //space counter to manipulate spaces as per the pattern
        /* Here I just, added a space counter and placed it in the if condition with star counter
           c as the stars increases space decreases. The loop for space is always increasing, so I
           changed the ending variable accordingly, like it starts from n-1 and decreases till row = n
           and increases gradually after row = n.
        */
        int totalSpace = n-1;
        for(int row = 1; row <= ((2*n)-1); row++){
            for(int space =0; space < totalSpace; space++){
                System.out.print(" ");
            }
            for(int col = 1; col <= star; col++){
                System.out.print("* ");
            }
            System.out.println();
            //first stars increases till row = n then decreases till row <= 2n-1
            /* here c already gets incremented after an iteration so when row is 4, it gets
               incremented to 5 that means at row = 5 it will print 5 stars due to previous
               increment and so the condition is for less than n not less than or equal to <= n.
            * */
            if(row < n){
                star++;
                totalSpace--;
            }
            else{
                star--;
                totalSpace++;
            }
        }
    }


    static void pattern5KunalMethod(int n) {
        /*Here there were 2 extra iterations in kunal's method, but I removed it by starting rows from 1 and ending at
          2n-1. so I checked by printing the (lines ---------- ) and I observed that there are extra iterations by
          counting the no of times the lines that are printed and found 2 extra iterations.
         */
        for (int row = 1; row < (2 * n) - 1; row++){
            int totalColsInRow = row > n ? 2 * n - row - 1 : row;
            System.out.println("--------------");
            for (int col = 0; col < totalColsInRow; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    /* for n=5 rows = 2n-1 ==> 9 rows
         *
         * *
         * * *
         * * * *
         * * * * *
         * * * *
         * * *
         * *
         *
     */
    static void pattern5(int n){
        int c = 1;

        for(int row = 1; row <= ((2*n)-1); row++){

            for(int col = 1; col <= c; col++){
                System.out.print("* ");
            }
            System.out.println();
            //first stars increases till row = n then decreases till row <= 2n-1
            /* here c already gets incremented after an iteration so when row is 4, it gets
               incremented to 5 that means at row = 5 it will print 5 stars due to previous
               increment and so the condition is for less than n not less than or equal to <= n.
            * */
            if(row < n){
                c++;
            }
            else{
                c--;
            }
        }
    }
    /*
        1
        1 2
        1 2 3
        1 2 3 4

    */

    static void pattern4(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print(col+" ");
            }
            System.out.println();
        }
    }
    /*
     * * * *
     * * *
     * *
     *

     */
    static void pattern3(int n) {
        for (int row = n; row >= 1; row--) {
            for (int col = 1; col <= row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern1(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n ; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern2(int n){
        for (int row = 1; row <= n; row++) {
            //for every row, run the col
            for (int col = 1; col <= row; col++) {
                System.out.print("* ");
            }
            //When one row is printed, we need to print a new line
            System.out.println();
        }
    }
}