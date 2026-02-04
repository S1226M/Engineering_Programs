public class Problem_24 {
    public static void main(String[] args) {
        int arr[] = { 10, 20, 30, 40, 50 };
        int s = 0;
        int e = (arr.length - 1);
        for(int i=0 ; i<((arr.length)/2) ; i++){
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;
            e--;
        }
        for(int i=0 ; i<arr.length ; i++){
            System.out.println(arr[i]);
        }
    }
}
