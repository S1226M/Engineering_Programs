
public class Veg {
    public static void main(String[] args) {
        Potato p1 = new Potato("Yellow");
        System.out.println(p1.toString());
        Bringle b1 = new Bringle("purple");
        System.out.println(b1.toString());
        Tomato t1 = new Tomato("red");
        System.out.println(t1.toString());
    }
}

abstract class Vegetable {
    String color;

    Vegetable(String color) {
        this.color = color;
    }

    public abstract String toString();
}

class Potato extends Vegetable {
    String name = "Potato";

    Potato(String color) {
        super(color);
    }

    public String toString() {
        return "Name : "+this.name+" | Color : "+super.color;
    }
}
class Bringle extends Vegetable {
    String name = "Bringle";

    Bringle(String color) {
        super(color);
    }

    public String toString() {
        return "Name : "+this.name+" | Color : "+super.color;
    }
}
class Tomato extends Vegetable {
    String name = "Tomato";

    Tomato(String color) {
        super(color);
    }

    public String toString() {
        return "Name : "+this.name+" | Color : "+super.color;
    }
}
