import java.util.Scanner;
public class pelindrom_number {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int reversed=0;
    System.out.print("enter the number:");
    int number=sc.nextInt();
    while(number!=0)
    {
        int digit = number % 10;
        reversed = reversed * 10 + digit;
        number = number/10;
    }
    System.out.println("reversed numer is="+reversed);
     if(number==reversed)
  {
    System.out.println("number is palindrom");
  }
  else
  {
    System.out.println("is it not palindrom  number");
  }
}
}