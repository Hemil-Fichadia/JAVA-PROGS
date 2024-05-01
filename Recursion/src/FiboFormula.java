public class FiboFormula {
    public static void main(String[] args) {
        System.out.println(fiboFormula(10));
    }

    static long fiboFormula(int n){
        //formula to find nth fibonacci number
        return (long)(Math.pow(((1 + Math.sqrt(5))/2),n)/ Math.sqrt(5));
    }
}
