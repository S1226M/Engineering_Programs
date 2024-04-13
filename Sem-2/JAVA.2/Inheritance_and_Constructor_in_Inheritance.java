class Base1{
    Base1(){
        System.out.println("I am a constructor of base class");
    }
    Base1(int x){
        System.out.println("I am a constructor of base class for value of x : "+x);
    }
}

class Derived1 extends Base1{
    Derived1(){
        System.out.println("i am a constructor of derived-1 class");
    }
    Derived1(int x , int y){
        super(x);
        System.out.println("i am a constructor of derived-1 class for value of y : "+y);
    }
}

class Derived2 extends Derived1{
    Derived2(){
        System.out.println("i am a constructor of derived-2 class");
    }
    Derived2(int x , int y , int z){
        super(x,y);
        System.out.println("i am a constructor of  derived-2 class for value of z :"+z);
    }
}

public class Inheritance_and_Constructor_in_Inheritance {
    public static void main(String[] args) {
        // Base1 b = new Base1();
        //Derived1 d2 = new Derived1();
        Derived2 d2 = new Derived2(1,2,3);
    }    
}