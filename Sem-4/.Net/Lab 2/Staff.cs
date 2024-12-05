using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab_2
{
    internal class Staff
    {
        String Name;
        String Department;
      public  String Designation;
        int Experience;
        double Salary;

        public void GetStaffDetails()
        {
            Console.Write("Enter name : ");
            Name = Console.ReadLine();

            Console.Write("Enter Department : ");
            Department = Console.ReadLine();

            Console.Write("Enter Designation : ");
            Designation = Console.ReadLine();

            Console.Write("Enter Experience : ");
            Experience = Convert.ToInt32(Console.ReadLine());

            Console.Write("Enter Salary : ");
            Salary = Convert.ToDouble(Console.ReadLine());
        }

        public void DisplayStaffDetails()
        {
            Console.Write("name : ");
            Console.WriteLine(Name);

            Console.Write("Salary : ");
            Console.WriteLine(Salary);
        }
    }
}
