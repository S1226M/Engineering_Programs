public class Sum_Of_Even {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sum = 0;
        for(int i=0 ; i<arr.length ; i++){
            if(arr[i] % 2 == 0) {            
                sum += arr[i];
            }
        }
        System.out.println("Sum of even numbers: " + sum);
        System.out.println("Sum of even numbers using streams: " +  
            java.util.Arrays.stream(arr).filter(n -> n % 2 == 0).sum());
    }
}