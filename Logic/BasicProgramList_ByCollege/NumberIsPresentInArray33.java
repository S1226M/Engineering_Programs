import java.util.*;

public class NumberIsPresentInArray33 {
    public static String checkNumInArr(int[] arr, int num){
        if(arr.length == 0){
            return "Number is not Present in the Array";
        }
        if(arr[arr.length-1] == num){
            return "Number is Present in the Array at index: " + (arr.length);
        }
        else{
            arr = Arrays.copyOfRange(arr, 0, arr.length-1);
            return checkNumInArr(arr, num);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = {10, 20, 30, 40, 50};
        String result = checkNumInArr(arr, n);
        System.err.println(result);
    }
}
