
import java.util.*;

public class Decimal_To_BCD_15 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        int decimal = sc.nextInt();
        ArrayList<Integer> bcd = new ArrayList<>();
        int reminder = decimal;
        while (reminder >= 1) {
            if (decimal == 1 || decimal == 0) {
                bcd.add(1);
                break;
            } else {
                if ((decimal % 2) == 0) {
                    bcd.add(0);
                } else {
                    bcd.add(1);
                }
                reminder = decimal / 2;
                decimal = reminder;
            }
        }
        if (bcd.size() % 4 != 0) {
            int toAdd = 4 - (bcd.size() % 4);
            for (int i = 0; i < toAdd; i++) {
                bcd.add(0);
            }
        }
        Collections.reverse(bcd);
        System.out.print("BCD representation: ");
        for (int bit : bcd) {
            System.out.print(bit + " ");
        }
    }
}
