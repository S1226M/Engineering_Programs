class Rectangle {
    int a;
    int b;

    public void setSide1(int side1) {
        a = side1;
    }

    public void setSide2(int side2) {
        b = side2;
    }

    public int printArea() {
        int ans = a * b;
        return ans;
    }
}

public class Class_Demo_Of_Square {
    public static void main(String[] args) {
        Rectangle s1 = new Rectangle();
        s1.setSide1(10);
        s1.setSide2(20);
        int area = s1.printArea();
        System.out.println("Area is = " + area);
    }
}
