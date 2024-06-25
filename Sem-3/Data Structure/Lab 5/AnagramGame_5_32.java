import java.util.Arrays;
import java.util.Scanner;

public class AnagramGame_5_32 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the number of strings: ");
        int size = sc.nextInt();
        sc.nextLine();
        
        String[] arr = new String[size];
        for (int i = 0; i < size; i++) {
            System.out.println("Enter string " + (i + 1) + ": ");
            arr[i] = sc.nextLine();
        }
        
        int a = (int) (Math.random() * size);
        String b = arr[a];
        System.out.println("Selected string: " + b);
        
        System.out.println("Enter a string to compare: ");
        String c = sc.nextLine();
        
        if (b.length() != c.length()) {
            System.out.println("This is not an anagram.");
            return;
        }
        
        char[] d = b.toCharArray();
        char[] e = c.toCharArray();
        
        Arrays.sort(d);
        Arrays.sort(e);
        
        if (Arrays.equals(d, e)) {
            System.out.println("This is an anagram.");
        } else {
            System.out.println("This is not an anagram.");
        }
    }
}