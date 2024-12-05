using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab_2
{
    internal class Candidate
    {
        int id;
        string name;
        int age;
        double weight;
        double height;

        public void GetCandidateDetails()
        {
            id = Convert.ToInt32(Console.ReadLine());
            name = Console.ReadLine();
            age = Convert.ToInt32(Console.ReadLine());
            weight = Convert.ToDouble(Console.ReadLine());
            height = Convert.ToDouble(Console.ReadLine());
        }
         public void DisplayCandidateDetails()
        {
            Console.WriteLine(id);
            Console.WriteLine(name);
            Console.WriteLine(age); 
            Console.WriteLine(weight);
            Console.WriteLine(height);
        }
    }
}
