import java.util.Scanner;

public class Bank_6_37 {
    long acountNo;
    float balance;
    String acountHolderName;
    float deposit; 
    float withdraw;
    public void getDetails(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter acount no.");
        acountNo = sc.nextLong();
        System.out.println("Enter balance");
        balance = sc.nextFloat();
        System.out.println("Enter acount holder name");
        acountHolderName = sc.next();
    }
    public void depositMoney(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter amount of deposit");
        deposit = sc.nextFloat();
        balance += deposit;
        System.out.println("Total Balance after deposit :"+balance);
    }
    public void withdrawMoney(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter amount of withdrow");
        withdraw = sc.nextFloat();
        balance -= withdraw;
        System.out.println("Total Balance after withdrow :"+balance);
    }
    public static void main(String[] args) {
        Bank_6_37 b = new Bank_6_37();
        b.getDetails();
        b.depositMoney();
        b.withdrawMoney();
    }
}
