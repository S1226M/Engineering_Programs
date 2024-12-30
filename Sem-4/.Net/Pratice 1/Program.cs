using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace Pratice_1
{
    public class Program
    {
        public static void Main(string[] args)
        {
            //int start = Convert.ToInt32(Console.ReadLine());
            //int end = Convert.ToInt32(Console.ReadLine());
            //int i = 2;
            //int count = 0;
            //for (int j=start; j<=end; j++)
            //{
            //    while (i <= j)
            //    {
            //        if (j % i == 0)
            //        {
            //            count++;
            //            i++;
            //        }
            //        else
            //        {
            //            i++;
            //        }
            //    }
            //    if(count == 1)
            //    {
            //        Console.Write(j + " , ");
            //    }
            //    i = 2;
            //}


            //Time t = new Time();
            //t.Add(0, 0, 0);

            //String s1 =Console.ReadLine();
            //char[] a = s1.ToCharArray();

            string a = Console.ReadLine();
            string b = Console.ReadLine();
            char[] arr1 = new char[a.Length];
            char[] arr2 = new char[b.Length];
            if (a.Length == b.Length)
            {
                for (int i = 0; i < a.Length; i++)
                {
                    arr1[i] = a[i];
                }
                for (int i = 0; i < b.Length; i++)
                {
                    arr2[i] = b[i];
                }
                Array.Sort(arr1);
                Array.Sort(arr2);
                if(arr1.ToString() == arr2.ToString())
                {
                    Console.WriteLine("Aanagram");
                }
            }
            else
            {
                Console.WriteLine("Not aanagram");
            }

            //string a = Console.ReadLine();
            //string b = Console.ReadLine();
            //char[] ar1 = a.ToCharArray();
            //char[] ar2 = b.ToCharArray();
            //Array.Sort(ar1);
            //Array.Sort(ar2);
            //string g = new string(ar1);
            //string h = new string(ar2);
            //if(g == h)
            //{
            //    Console.WriteLine("true");
            //}
            //else
            //{
            //    Console.WriteLine("false");
            //}
        }
    }
}