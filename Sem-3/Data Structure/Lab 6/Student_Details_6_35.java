import java.util.Scanner;

public class Student_Details_6_35 {
    long enrollment_no;
    String name;
    int semester;
    Double CPI;

    public void setDetails(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter enrollment number:");
        enrollment_no = sc.nextLong();
        System.out.println("Enter name:");
        name = sc.next();
        System.out.println("Enter semester:");
        semester = sc.nextInt();
        System.out.println("Enter CPI:");
        CPI = sc.nextDouble();
    }

    public void getDetails(){
        System.out.println("Enrollment number: " + enrollment_no);
        System.out.println("Name: " + name);
        System.out.println("Semester: " + semester);
        System.out.println("CPI: " + CPI);
    }

    public static void main(String[] args) {
        Student_Details_6_35[] students = new Student_Details_6_35[5];
        for(int i = 0; i < 5; i++){
            students[i] = new Student_Details_6_35();
            students[i].setDetails();
        }
        for(int i = 0; i < 5; i++){
            students[i].getDetails();
        }
    }
}
