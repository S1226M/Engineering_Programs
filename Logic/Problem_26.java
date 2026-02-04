import java.util.Arrays;

public class Problem_26 {
    public static void main(String[] args) {
        int arr[] = { 5 , 1 , 9 , 7 , 1 , 5 , 3 };
        Arrays.sort(arr);
        int secondSmallest = arr[1];
        int secondLargest = arr[arr.length - 2];
        System.out.print("Difference is = "+(secondLargest-secondSmallest));
    }
}