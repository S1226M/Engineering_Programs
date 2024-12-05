using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab_2
{
    internal class Bank_Account
    {
        int Account_No;
        String Email;
        String User_Name;
        String Account_Type;
        double Account_Balance;

        public void GetDetails()
        {
            Console.WriteLine("Enter A_No. : ");
            Account_No = Convert.ToInt32(Console.ReadLine());

            Console.WriteLine("Email :");
            Email = Console.ReadLine();

            Console.WriteLine("Enter name");
            User_Name = Console.ReadLine();

            Console.WriteLine("Enter type");
            Account_Type = Console.ReadLine();

            Console.WriteLine("Balance");
            Account_Balance = Convert.ToDouble(Console.ReadLine());
        }

        public void printDetails()
        {
            Console.WriteLine(Account_No);
            Console.WriteLine(Email);
            Console.WriteLine(User_Name);
            Console.WriteLine(Account_Type);
            Console.WriteLine(Account_Balance);
        }
    }
}
