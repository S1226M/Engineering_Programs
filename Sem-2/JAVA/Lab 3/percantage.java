import java.util.Scanner;
// import javax.swing.plaf.synth.SynthOptionPaneUI;
public class percantage{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("enter the marks of maths");
        int maths=sc.nextInt();
        System.out.print("enter the marks of english");
        int english=sc.nextInt();
        System.out.print("enter the marks of drowing");
        int drowing=sc.nextInt();
        System.out.print("enter the marks of computer");
        int computer=sc.nextInt();
        int sum=(maths+english+drowing+computer);
        float persantage=(sum*100)/400;
        System.out.println("total persantage="+persantage);
        if(persantage>=60){
            System.out.println("first divisation");
        }
        else if(persantage>=50){
            System.out.println("second divisation");
        }
        else if(persantage>=40){
            System.out.println("third divisation");
        }
        else if(persantage<40){
            System.out.println("fail divisation");
        }
    }
}