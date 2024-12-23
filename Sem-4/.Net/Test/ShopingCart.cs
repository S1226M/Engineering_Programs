using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Test
{
    internal class ShopingCart
    {
        string name;
        int quantity;
        double price;
        int code;
        public void AddItem(string n, int q)
        {
            name = n;
            quantity = q;
            Console.Write("Name : "+name);
            Console.WriteLine(" , Quantity : " + quantity);
        }

        public void AddItem(string n, int q, double p) 
        {
            name = n;
            quantity = q;
            price = p;
            Console.Write("Name : "+name);
            Console.Write(" , Quantity : " + quantity);
            Console.WriteLine(" , Price :"+price);
        }

        public void AddItem(int c, int q) 
        {
            code = c;
            quantity = q;
            Console.Write(" , Code : "+code);
            Console.WriteLine(" , Quantity : " + quantity);
        }
    }
}
