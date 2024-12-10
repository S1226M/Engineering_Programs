using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab_4
{
    internal  class RBI
    {
        public virtual void calculateInterest()
        {
            double p = Convert.ToDouble(Console.ReadLine());
            double r = Convert.ToDouble(Console.ReadLine());
            double n = Convert.ToDouble(Console.ReadLine());

            double intrest = (p * r * n) / 100;
            Console.WriteLine(intrest);
        }
    }
    class HDFC : RBI
    {
        public override void calculateInterest()
        {
            Console.Write("HDFC");
        }
    }
    class SBI : RBI
    {
        public override void calculateInterest()
        {
            Console.Write("SBI");
        }
    }
    class ICICI : RBI
    {
        public override void calculateInterest()
        {
            Console.Write("ICICI");
        }
    }
}
