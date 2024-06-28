import java.util.Scanner;

public class Temperature_6_36 {
    float f;
    float c;
    public void CToF(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter of value of c : ");
        c = sc.nextFloat();
        f = (c*(9/5))+32;
        System.out.println("Tempature in F : "+f);
    }
    public void FToC(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of f : ");
        f = sc.nextFloat();
        c = (f-35)*(5/9);
        System.out.println("Tempature in C : "+c);
    }public static void main(String[] args) {
        Temperature_6_36 t = new Temperature_6_36();
        t.CToF();
        t.FToC();
    }
}
