public class Area {
    public static void main(String[] args){
        Ar c1= new Ar();
        Ar a1=new Ar();
        double radius=c1.areaOfCircle(10);
        double length=a1.areaOfRec(5, 6);
        System.out.println("the ans of circle is"+radius);
        System.out.println("the ans is"+length);
    }
}
class Ar {
    double areaOfCircle(int r) {
        double ans = Math.PI * r * r;
        return ans;
    }

    double areaOfRec(int a, int b) {
        double ans = a * b;
        return ans;
    }
}