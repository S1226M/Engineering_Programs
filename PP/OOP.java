interface Vehicle { // Interface

    void brake();

    void horn();
}

abstract class Car implements Vehicle { // Abstraction + Interface

    private String name = "BMW";

    String demo = "asdf super";

    Car() {
        System.out.println("Parent Constructor : " + this.name);
    }

    void start() {
        System.out.println("Push Start Car Super");
        System.out.println(demo);
    }

    void start(String keyName) {
        System.out.println("Start using key : " + keyName);
    }

    abstract void reverse();
}

class Engine {
    void engineInfo() {
        System.out.println("Engine Attached");
    }
}

class subCar extends Car {

    String demo = "asdf sub";

    Engine engine = new Engine();

    subCar() {
        super();
        System.out.println("Child Constructor");
    }

    @Override
    void start() {
        System.out.println("Start By Key Sub");

        System.out.println("Child demo : " + this.demo);
        System.out.println("Parent demo : " + super.demo);
    }

    @Override
    void reverse() {
        System.out.println("Add reverse gear");
    }

    @Override
    public void brake() {
        System.out.println("Brake Applied");
    }

    @Override
    public void horn() {
        System.out.println("Horn Pressed");
    }
}

public class OOP {

    public static void main(String[] args) {

        Car sc = new subCar();

        sc.start();
        sc.start("BMW Key");
        sc.reverse();

        subCar c = (subCar) sc;

        c.brake();
        c.horn();

        c.engine.engineInfo();
    }
}