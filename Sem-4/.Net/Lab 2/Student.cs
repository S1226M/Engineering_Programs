using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab_2
{
    internal class Student
    {
        int Enrollment_No;
        string Student_Name;
        int Semester;
        double CPI;
        double SPI;

        public Student(int Enrollment_No, string Student_Name , int Semester , double CPI , double SPI)
        {
            this.Enrollment_No = Enrollment_No;
            this.Student_Name = Student_Name;
            this.Semester = Semester;
            this.CPI = CPI;
            this.SPI =SPI;
        }

        public void print()
        {
            Console.WriteLine(Enrollment_No);
            Console.WriteLine(Student_Name);
            Console.WriteLine(Semester);
            Console.WriteLine(CPI);
            Console.WriteLine(SPI);
        }
    }
}
