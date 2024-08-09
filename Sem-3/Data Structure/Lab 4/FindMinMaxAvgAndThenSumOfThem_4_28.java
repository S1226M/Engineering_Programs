import java.util.Scanner;

public class FindMinMaxAvgAndThenSumOfThem_4_28 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the size of arr");
            int a = sc.nextInt();
            int arr[] = new int[a];
            for(int i=0 ; i<a ; i++){
                arr[i] = sc.nextInt();
            }
            int max = 0;
            for(int i=0 ; i<arr.length ; i++){
                for(int j=i+1 ; j<arr.length ; j++){
                    if(arr[i] > arr[j]){
                        max = arr[i];
                    }
                    else{
                        max = arr[j];
                    }
                }
            }
            int min = arr[0];
            for(int i=0 ; i<arr.length ; i++){
                for(int j=i+1 ; j<arr.length ; j++){
                    if(min < arr[j]){
                    }
                    else{
                        min = arr[j];
                    }
                }
            }
            int avg;
            int sumOfArrayElement = 0;
            for(int i=0 ; i<arr.length ; i++){
                sumOfArrayElement+=arr[i];
            }
            avg = sumOfArrayElement/a;
            int sum = (max + min + avg);
            System.out.println("Max element in array : "+max);
            System.out.println("Min element in array : "+min);
            System.out.println("Average of all element :"+avg);
            System.out.println("Sum of Min Max And Average : "+sum);
        }
    }
}