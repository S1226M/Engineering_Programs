using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab_4
{
    internal class Bank
    {
        String name;
        double balance;
        double amount;
        public Bank()
        {
            name = Console.ReadLine();
            balance = Convert.ToDouble(Console.ReadLine());
        }
        public double depositCashe(double d)
        {
            return (balance + d);
        }
        public double withdrawCashe(double w)
        {
            return (balance - w);
        }
        public double depositCheck(double d)
        {
            return (balance + d);
        }
        public double withdrawCheck(double w)
        {
            return (balance - w);
        }
    }
}
