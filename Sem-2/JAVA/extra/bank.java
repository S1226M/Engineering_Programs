import java.util.*;
class bankdetails{
    int accountno;
    int balance;
    String name;
    // static count=0;
    void getdetails() {
        System.out.println("plese enter account number");
        Scanner sc = new Scanner(System.in);
        accountno = sc.nextInt();
        System.out.println("plese enter your bank balance");
        balance = sc.nextInt();
        System.out.println("plese etner your name");
        name = sc.next();
    }
    void printdetails(){
       System.out.println(this.accountno);
       System.out.println(this.balance);
       System.out.println(this.name);
    //    System.out.println(this.count);
    }
    void bankvariable(){
    }

}`
public class bank { 
    public static void main(String[] args) {
        bankdetails b1=new bankdetails();
        b1.getdetails();
        b1.printdetails();
    }
}