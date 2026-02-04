import java.util.Arrays;

public class Problem_30 {

    public static int fun(int arr[], int n) {

        if (arr[0] == n) {
            return 1;
        }
        else if (arr[0] == -1) {
            return 0;
        }
        else {
            int newArr[] = Arrays.copyOfRange(arr, 1, arr.length);
            return fun(newArr, n);
        }
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,-1};
        System.out.println(fun(arr, 4));
    }
}
