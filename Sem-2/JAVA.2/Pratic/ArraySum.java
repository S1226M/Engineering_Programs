public class ArraySum {
    public static void main(String[] args) {
        // Declare and initialize an array
        int[] numbers = {10, 20, 30, 40, 50};
        
        // Variable to store the sum
        int sum = 0;
        
        // Iterate through the array and calculate the sum
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        
        // Print the sum
        System.out.println("Sum of array elements: " + sum);
    }
}
