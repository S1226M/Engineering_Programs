import java.util.*; 
class SumUsingScannerAndCLA 
{ 
 public static void main(String[] args)  
 { 
  Scanner sc= new Scanner(System.in);   
  System.out.println("Sum using CommandLineArgument");
  int a=Integer.parseInt(args[0]);
  int b=Integer.parseInt(args[1]); 
  System.out.println("Sum:: "+(a+b)); 
  System.out.println("Sum using Scanner"); 
  System.out.print("Enter Number-1 :: "); 
  int no1=sc.nextInt(); 
  System.out.print("Enter Number-2 :: "); 
  int no2=sc.nextInt(); 
  System.out.println("Sum :: "+(no1+no2)); 
 } 
}