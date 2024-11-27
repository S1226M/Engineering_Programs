import java.util.Scanner;

public class FindFecctorialOfAnumber_12_4 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int a = sc.nextInt();
            int ans = 1;
            for(int i=1;i<=a;i++){
                ans*=i;
            }
            System.out.println("Factorial of given number is : "+ans);
        }
    }
}



// import java.util.Scanner;

// class factorial{
//     int fac(int a){
//         if(a==0 || a==1){
//             return 1;
//         }
//         return a * fac(a-1);
//     }
// }
// public  class FindFecctorialOfAnumber_12_4{
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         factorial f1 = new factorial();
//         int number = sc.nextInt();
//         if( number < 0 ){
//             System.out.println("Factorial is not possible for negative number");
//         }
//         else{
//             int ans = f1.fac(number);
//             System.out.println();
//         }
//     }
// }