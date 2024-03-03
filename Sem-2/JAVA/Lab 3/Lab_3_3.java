import java.util.*;
public class Lab_3_3{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("enter the value of n :");
    int n = sc.nextInt();
    int i=2;
    int count=0;
    if(i<=n/2)
    {
      if(n%i==0)
      {
        count++;
      }
      else
      {
        
      }
    }
  }
}











//public class Lab_3_3 {
  //         public static void main(String[] args) {
  //           boolean flag = false;
  //           for (int i = 2; i <= num / 2; ++i) {
  //             // condition for nonprime number
  //             if (num % i == 0) {
  //               flag = true;
  //               break;
  //             }
  //           }
        
  //           if (!flag)
  //           {
  //             System.out.println(num + " is a prime number.");
  //             }
  //           else
  //           {
  //             System.out.println(num + " is not a prime number.");
  //             }
  //         }
  //       }
  // }
  