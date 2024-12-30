using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Pratice_1
{
    public class Time
    {
        int s;
        int m;
        int h;
        public Time() 
        {
            s = Convert.ToInt32(Console.ReadLine());
            m = Convert.ToInt32(Console.ReadLine());
            h = Convert.ToInt32(Console.ReadLine());
        }
        public Time(Time other)
        {
            Console.WriteLine(other.h+":"+other.m+":"+other.s);
        }

        public void Add(int s, int m, int h) 
        {
            this.s = s + s;
            if (s > 60)
            {
                m++;
                s = s - 60;
            }
            this.m = m + m;
            if (m > 60)
            {
                h++;
                m = m - 60;
            }
            this.h = h + h;
            Console.WriteLine(h+":"+m+":"+s);
        }
    }
}
