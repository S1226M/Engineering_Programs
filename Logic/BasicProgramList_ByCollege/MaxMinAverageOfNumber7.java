import java.util.Scanner;

public class MaxMinAverageOfNumber7 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter numbers separated by space: ");
        String input = sc.nextLine();

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int numbers = 0;
        String str = "";

        for(int i = 0; i < input.length(); i++) {

            if(input.charAt(i) != ' ') {
                str += input.charAt(i);
            } 
            else {
                int num = Integer.parseInt(str);

                if(num < min) min = num;
                if(num > max) max = num;

                sum += num;
                numbers++;

                str = "";
            }
        }

        // process last number
        int num = Integer.parseInt(str);
        if(num < min) min = num;
        if(num > max) max = num;
        sum += num;
        numbers++;

        int avg = sum / numbers;

        System.out.println("Minimum number is: " + min);
        System.out.println("Maximum number is: " + max);
        System.out.println("Average number is: " + avg);
    }
}