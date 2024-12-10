using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab_4
{
    internal class AreaOfSRC
    {
        public double area(int a)
        {
            return (a * a);
        }
        public double area(int a , int b)
        {
            return (a * b);
        }
        public double area(double a)
        {
            return (3.14*a * a);
        }
    }
}
