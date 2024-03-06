interface A1{
    int a=10;
}
interface A2{
    int b=20;
}
interface A extends A1,A2{
    int c=a+b;

    static void printDetails(){
        System.out.println("sum ="+c);
    }
}
interface P1{
    void MethodP1();
    int f=30;
}
interface P2{
    void MethodP2();
    int d=40;
}
interface A12 extends P1,P2{
    void MethodA12();
    int e=d-f;
    static void printDetails(){
        System.out.println("differance ="+e);
    }
}
class B implements A12{
    public void MethodA12() {
        System.out.println("A12 impliment in B");
    }
    public void MethodP1() {
        System.out.println("P1 impliment in B");
    }
    public void MethodP2() {
        System.out.print("P2 impliment in B");
    }

}
public class illustrates_Interface_Inheritance_Demo {
    public static void main(String[] args) {
        B b =new B();
        b.MethodA12();
        b.MethodP1();
        b.MethodP2();
    }
}