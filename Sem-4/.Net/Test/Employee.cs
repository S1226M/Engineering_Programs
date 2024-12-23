using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Text;
using System.Threading.Tasks;

namespace Test
{
    public class Employee
    {
        int EmployeeID;
        string Name;
        double Salaries;

        public void InputDetails()
        {
            Console.Write("Enter Employee ID :");
            EmployeeID = Convert.ToInt32(Console.ReadLine());
            Console.Write("Enter Name :");
            Name = Console.ReadLine();
            Console.Write("Enter Monthly Salaries :");
            Salaries = Convert.ToDouble(Console.ReadLine());
        }

        public void DisplayDEtails()
        {
            Console.WriteLine("Employee id = " + EmployeeID);
            Console.WriteLine("Employee Name = " + Name);
            Console.WriteLine("Employee Monthly salary = " + Salaries);
        }

        public double CalculateAnualSalary(double s)
        {
            return s*12;
        }

        public void DeterminePermance(double s)
        {
            if(s > 1000000)
            {
                Console.WriteLine("Outstanding");
            }
            else if(s >= 500000 &&  s <= 1000000)
            {
                Console.WriteLine("Excellent");
            }
            else if(s >= 250000 && s<= 499999)
            {
                Console.WriteLine("Good");
            }
            else
            {
                Console.WriteLine("Need to improve");
            }
        }
    }
}
