// --------------- Itrative Method ---------------- //
// public class Summation_Of_Digit {
//     public static void main(String[] args) {
//         int number = 12345;
//         int sum = 0;

//         while (number != 0) {
//             sum += number % 10;
//             number /= 10;
//         }

//         System.out.println("The sum of the digits is: " + sum);
//     }
// }

// --------------- recursive Method ------------------ //
public class Summation_Of_Digit{
    public static void main(String[] args) {
        int number = 23456;
        int sum = sumOfDigits(number);
        System.out.println("The sum of the digits is: " + sum);
    }
    public static  int sumOfDigits(int number){
        if(number == 0){
            return 0;
        }
        else{
            return  number %10 + sumOfDigits(number / 10);
        }
    }
}
