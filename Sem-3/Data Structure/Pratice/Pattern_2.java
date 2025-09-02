import java.util.Scanner;

public class Pattern_2 {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int a = sc.nextInt();
        char c = 'A';
        System.out.print(c);
        int n = 1;
        for(int i=0 ; i<a ; i++){
            for(int j=0 ; j<i ; j++){
                if(i%2==0){
                    System.out.print(c++);
                }
                else{
                    System.out.print(n++);
                }
            }
            System.out.println();
        }
    }    
}
