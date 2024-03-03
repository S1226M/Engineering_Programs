import java.util.Scanner;

public class Bank {
    public static void main(String[] args) {
        BankAccount a1 = new BankAccount();
        a1.getAccountDetails();
        a1.displayAccountDetails();
    }
}

class BankAccount {
    int accountNo;
    String userName;
    String email;
    String accountType;
    double accountBalance;

    void getAccountDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.println("plese enter account number:-");
        accountNo = sc.nextInt();
        System.out.println("plese enter username:-");
        userName = sc.next();
        System.out.println("plese enter your email:-");
        email = sc.next();
        System.out.println("plese enter account type:-");
        accountType = sc.next();
        System.out.println("plese enter your account belence:-");
        accountBalance = sc.nextInt();
        sc.close();
    }

    void displayAccountDetails() {
        System.out.println("account number is:-" + accountNo);
        System.out.println("account unsername is:-" + userName);
        System.out.println("account email is:-" + email);
        System.out.println("account type is:-" + accountType);
        System.out.println("account balance is:-" + accountBalance);
    }
}