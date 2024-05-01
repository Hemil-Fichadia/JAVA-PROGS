public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 45, 68, 101};
        int target =45;
        int start = 0;
        int end = (arr.length)-1;
        int ans = BS(arr, target, start, end);
        System.out.println(ans);
    }

    static int BS(int[] arr, int target, int start, int end){
        if(start > end){
            return -1;
        }
        int m = start + (end - start) / 2;

        if(arr[m] == target){
            return m;
        }
        else if(target < arr[m]){
            return BS(arr, target, start, m-1);
        }
        return BS(arr, target, m+1, end);
    }
}
