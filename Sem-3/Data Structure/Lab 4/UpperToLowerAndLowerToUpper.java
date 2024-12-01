
import java.util.*;

public class UpperToLowerAndLowerToUpper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String s = sc.nextLine();
        if(s.equals(s.toLowerCase())){
            s=s.toUpperCase();
        }
        else{
            s=s.toLowerCase();
        }
        System.out.println(s);
        sc.close();
    }
}