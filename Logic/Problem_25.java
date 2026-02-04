import java.util.Scanner;

public class Problem_25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the total Rupies : ");
        int r = sc.nextInt();
        System.out.print("Enter price of each chocolate : ");
        int pOfc = sc.nextInt();
        System.out.print("Enter No. of Wraper per Chocolate : ");
        int wToC = sc.nextInt();

        int chocolate = r / pOfc;
        int Wraper = chocolate;
        while (Wraper >= 0 ) {
            if (Wraper >= wToC){
                Wraper = Wraper - wToC;
                chocolate++;
                Wraper++;
            }
            else{
                break;
            }
        }
        System.out.print("No of chocolate that you can eat : "+chocolate);
    }
}
