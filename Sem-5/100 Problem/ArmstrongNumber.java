
import java.util.*;

public class ArmstrongNumber {

    Scanner sc = new Scanner(System.in);
    String n = sc.nextLine();
    int len = n.length();
    int sum = 0;


for(int i=0 ; i<len ; i++){
        int digit = n.charAt(i) - '0';
        sum += pow(digit,len);
    }
}
