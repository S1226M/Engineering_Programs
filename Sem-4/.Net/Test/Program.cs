using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Test
{
    internal class Program
    {
        static void Main(string[] args)
        {
            //Find Max and Min From Array
            //Console.Write("Enter the size of array : ");
            //int n = Convert.ToInt32(Console.ReadLine());
            //int[] a = new int[n];

            //for (int i = 0; i < n; i++)
            //{
            //    Console.Write("Enter the " + (i + 1) + "th value of array : ");
            //    a[i] = Convert.ToInt32(Console.ReadLine());
            //}

            //int Large = a[0];
            //int Small = a[0];
            //for (int i = 1; i < a.Length; i++)
            //{
            //    if (a[i] < Small)
            //    {
            //        Small = a[i];
            //    }
            //    else if (a[i] > Large)
            //    {
            //        Large = a[i];
            //    }
            //}
            //Console.WriteLine("Largest Number = " + Large + " & Smallest number = " + Small);

            //Calculate Houre Min And Sec.
            //Console.Write("Enter the Second : ");
            //double t = Convert.ToDouble(Console.ReadLine());
            //t = t / 3600;
            //int H = Convert.ToInt32(t);
            //Console.Write(H + " Houre : ");
            //t = t - H;
            //t = t * 60;
            //int M = Convert.ToInt32(t);
            //Console.Write(M + " Mintes : ");
            //t = t - M;
            //t = t * 60;
            //int S = Convert.ToInt32(t);
            //Console.Write(S+" Second : ");

            //method of get and display Book details
            //Book b = new Book(10,"smit","hello");
            //b.Display();

            //Employee
            //Employee e = new Employee();
            //e.InputDetails();
            //e.DisplayDEtails();
            //double sa = e.CalculateAnualSalary(250000);
            //Console.Write("Employee Anual Salary = ");
            //Console.WriteLine(sa);
            //e.DeterminePermance(sa);

            //ShopingCart s = new ShopingCart();
            //s.AddItem("AA", 2);

            Console.Write("Enter the size of array : ");
            int n = Convert.ToInt32(Console.ReadLine());
            int[] a = new int[n];

            for (int i = 0; i < n; i++)
            {
                Console.Write("Enter the " + (i + 1) + "th value of array : ");
                a[i] = Convert.ToInt32(Console.ReadLine());
            }
            
            Array.Sort(a);
            for (int i = 0; i < n; i++) 
            {
                int count = 1;
                int now = a[i];
                while (a[i] > now)
                {
                    count++;
                    i++;
                }
                Console.WriteLine("Number of" + now + " = " +count);
            }
        }
    }
}
