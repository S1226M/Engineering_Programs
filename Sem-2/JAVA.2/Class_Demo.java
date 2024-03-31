class Employ{
    int salary;
    String name;
    public int getsalary(){
        return salary;
    }
    public String getname(){
        return name;
    }
    public void setname(String n){
        name = n;
    } 
}
public class Class_Demo {
    public static void main(String[] args) {
        Employ e1 = new Employ();
        e1.setname("Smit");
        System.err.println("name of employ is :"+e1.getname());
        e1.salary=100000;
        System.out.println("salary of employ is :"+e1.getsalary());
    }
}
