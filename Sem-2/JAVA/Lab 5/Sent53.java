import java.util.Scanner;
public class Sent53 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("plese eter your string");
        String s=sc.nextLine();
        Count a=new Count(s);
        sc.close();
        System.out.println(a);
    }
}

class Count {
    Count(String s){
        int count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='q'){
                if (s.charAt(i+1)=='u') {
                    if (s.charAt(i+2)=='i') {
                        if (s.charAt(i+3)=='t') {
                            break;
                        }
                    }
                }
            }
            if(s.charAt(i)=='A'||s.charAt(i)=='E'||s.charAt(i)=='I'||s.charAt(i)=='O'||s.charAt(i)=='U'){
                count++;
            }
            if(s.charAt(i)=='a'||s.charAt(i)=='e'||s.charAt(i)=='i'||s.charAt(i)=='o'||s.charAt(i)=='u'){
                count++;
            }
        }
        System.out.println(count);
    }

}
