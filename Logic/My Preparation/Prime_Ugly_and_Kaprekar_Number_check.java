import java.util.Scanner;

public class Prime_Ugly_and_Kaprekar_Number_check {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Check Number is Prime Or Note
        System.out.println("Enter Number for the Prime Check :");
        int n = sc.nextInt();
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
            }
        }
        if (count == 2) {
            System.out.println("N is Prime Number");
        } else {
            System.out.println("N is not a Prime Number");
        }

        // Check Ugly Number
        System.out.println("Enter Number for the Ugly Number Check :");
        int Ugly = sc.nextInt();
        int temp = Ugly;
        int arr[] = { 2, 3, 5 };
        for (int i : arr) {
            while (temp % i == 0) {
                temp /= i;
            }
        }
        if (temp == 1) {
            System.out.println("Enter Number " + Ugly + " is Ugly Number.");
        } else {
            System.out.println("Enter Number " + Ugly + "is not Ugly Number.");
        }

        // Check Kaprekar Number
        System.out.println("Enter Number for the Kaprekar Number Check :");
        int kaprekar = sc.nextInt();
        int n2 = kaprekar * kaprekar;
        String n2String = String.valueOf(n2);
        for (int i = 1; i < n2String.length(); i++) {
            String left = n2String.substring(0, i);
            String right = n2String.substring(i);

            int leftInt = Integer.parseInt(left);
            int rightInt = Integer.parseInt(right);

            if ((leftInt + rightInt) == kaprekar) {
                System.out.println("This is Kaprekar Number");
                break;
            }
        }

        sc.close();
    }
}