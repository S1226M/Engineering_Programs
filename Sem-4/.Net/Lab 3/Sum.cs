using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab_3
{
    abstract class Sum
    {
        public abstract void SumOfTwo(int a, int b);
        public abstract void SumOfThree(int a, int b, int c);
    }
    class Calculate : Sum
    {
        public override void SumOfTwo(int a, int b)
        {
            int ans = a + b;
            Console.WriteLine(ans);
        }
        public override void SumOfThree(int a, int b, int c)
        {
            int ans = a + b + c;
            Console.WriteLine(ans);
        }
    }
}
