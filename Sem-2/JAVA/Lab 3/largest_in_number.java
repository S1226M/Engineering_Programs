import java.util.*;
public class largest_in_number {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in); 
    System.out.print("enter the A:");
    int A=sc.nextInt();
    System.out.print("enter the B:");
    int B=sc.nextInt();
    System.out.print("enter the C:");
    int C=sc.nextInt();
    if(A>B)
    {
        if(A>C)
        {
            System.out.println("A is largest number");
        }
        else
        {
            System.out.println("C is largest number");
        }
    }   
    else
    {
        if(B>C)
        {
            System.out.println("B is largest number");
        }
        else
        {
            System.out.println("C is largest number");
        }
    }
    }
}