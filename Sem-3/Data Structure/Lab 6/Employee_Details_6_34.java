import java.util.Scanner;

public class Employee_Details_6_34 {
    int employee_id;
    String name;
    String designation;
    Double salary;
    public void readEmployee(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Entre id");
        employee_id = sc.nextInt();
        System.out.println("Enter name");
        name = sc.next();
        System.out.println("Enter Designation");
        designation = sc.next();
        System.out.println("Enter salary");
        salary = sc.nextDouble();
    }
    public void displayEmployee(){
        System.out.println("id = "+employee_id);
        System.out.println("name = "+name);
        System.out.println("Designation = "+designation);
        System.out.println("salary = "+salary);
    }
    public static void main(String[] args) {
        Employee_Details_6_34 e = new Employee_Details_6_34();
        e.readEmployee();
        e.displayEmployee();
    }
}
