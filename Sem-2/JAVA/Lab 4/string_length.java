//5a
import java.util.Scanner;
public class string_length {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("plese enter a string");
        String s=sc.nextLine();
        System.out.println("the length of string is:="+s.length());
        for(int i=s.length()/2;i<s.length();i++){
            System.out.print(s.charAt(i));
        }
        System.out.println(" ");
        sc.close();
    }
}
