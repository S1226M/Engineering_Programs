public class Automorphic_Pronic_Numbers {
    public static void main(String[] args) {
        int n = 25;
        int Square = n * n;
        boolean flag = true;
        while (n > 0) {
            int digit1 = n % 10;
            int digit2 = Square % 10;
            if (digit1 == digit2) {
                n /= 10;
                Square /= 10;
            } else {
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("Number is Automorphic");
        }
    }
}
