public class EvenWithoutModulo4 {
    public static void main(String[] args) {
        int n = 121;

        if ((n & 1) == 0) {
            System.out.println("Even");
        } else {
            System.out.println("Odd");
        }
    }
}