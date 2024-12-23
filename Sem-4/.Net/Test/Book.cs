using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Test
{
    public class Book
    {
        int BookID;
        string Title;
        string Author;
        public Book(int id,string t,string a)
        {
            BookID = id;
            Title = t;
            Author = a;
        }

        public void getDetails()
        {
            Console.Write("Enter Book ID :");
            BookID = Convert.ToInt32(Console.ReadLine());
            Console.Write("Enter Book Title :");
            Title = Console.ReadLine();
            Console.Write("Enter Book Author Name :");
            Author = Console.ReadLine();
        }

        public void Display()
        {
            Console.WriteLine("Book ID : "+BookID);
            Console.WriteLine("Book Title : "+Title);
            Console.WriteLine("Book Author : " +Author);
        }
    }
}
