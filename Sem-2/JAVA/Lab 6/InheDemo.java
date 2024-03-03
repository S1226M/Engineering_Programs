public class InheDemo {
    public static void main(String[] args) {
        Employee e1 = new Employee("a", 18, 1234, "ABC", 1500, "java");
        Manager m1 = new Manager("b", 17, 456, "def", 100000, "bsc");
        e1.printDe();
        System.out.println("");
        m1.printDe();
    }
}

class Member {
    String name;
    int age;
    int phonenum;
    String address;
    int salary;
    void printSalary() {
        System.out.println(salary);
    }

    void printDetails() {
        System.out.println("the name is:-" + name);
        System.out.println("the age is:-" + age);
        System.out.println("the phonenum is:-" + phonenum);
        System.out.println("the address is:-" + address);
        printSalary();
    }
}

class Employee extends Member {
    String specialization;

    Employee(String n, int a, int p, String add, int s, String sp) {
        super.name = n;
        super.age = a;
        super.phonenum = p;
        super.address = add;
        super.salary = s;
        specialization = sp;
    }
    void printDe(){
        super.printDetails();
        System.out.print("the specialization of employee is:-");
        System.out.println(specialization);
    }
}

class Manager extends Member {
    String department;

    Manager(String n, int a, int p, String add, int s, String dp) {
        super.name = n;
        super.age = a;
        super.phonenum = p;
        super.address = add;
        super.salary = s;
        this.department = dp;
    }
    void printDe(){
        super.printDetails();
        System.out.print("the department of manager is:-");
        System.out.println(department);
    }
}