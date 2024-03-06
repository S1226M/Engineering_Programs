abstract class Vegetable{
    String name;
    String color;
    Vegetable(String name,String color){
        this.name=name;
        this.color=color;
    }
}
class Potato extends Vegetable{
    Potato(String name,String color){
        super(name,color);
    }
    public void display(){
        System.out.println("");
        System.out.println("color of "+name+" is "+color+".");
    }
}
class Bringle extends Vegetable{
    Bringle(String name,String color){
        super(name,color);
    }
    public void display(){
        System.out.println("color of "+name+" is "+color+".");
    }
}
class Tometo extends Vegetable{
    Tometo(String name,String color){
        super(name,color);
    }
    public void display(){
        System.out.println("color of "+name+" is "+color+".");
    }
}
public class Vege_Using_DisplayMethod{
    public static void main(String[] args) {
        Potato p1=new Potato("Potato", "Yellow");
        p1.display();
        Bringle b1=new Bringle("Bringle", "Purpal");
        b1.display();
        Tometo t1=new Tometo("Tometo", "Red");
        t1.display();
    }
}