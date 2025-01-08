using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DemoExam
{
    class Animal
    {
        private int a;
        protected int b;
    }
    internal class Program : Animal
    {
        static void Main(string[] args)
        {
            //differance between this two
            //string s2 = Console.ReadLine();
            //int s = Console.Read();
            //Console.WriteLine(s);
            //Console.WriteLine(s2);

            //ConsoleKeyInfo s = Console.ReadKey();
            //Console.WriteLine(s);

            //int[] a = { 1, 2, 3 };
            //a[0] = 5;
            //Console.WriteLine(a[0]);

            //string s = "Smitm";
            //Console.WriteLine(s.Insert(1,"Hellom"));//SHellomit
            //Console.WriteLine(s.LastIndexOf('m'));
            //Console.WriteLine(s.Remove(1));
            //Console.WriteLine(s);
            //Console.WriteLine(s.Clone());

            int[] a = { 1, 2, 3 };
            foreach (int i in a)
            {
                Console.WriteLine(i);
            }

            Animal abc = new Animal();

            //a.a = 1;
            a.b = 10;

        }
    }
}
