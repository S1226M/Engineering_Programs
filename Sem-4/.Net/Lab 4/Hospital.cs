using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab_4
{
    internal class Hospital
    {
        public virtual String HospitalDetails()
        {
            String name = Console.ReadLine();
            return name;
        }
    }
    class Apollo : Hospital
    {
        public override String HospitalDetails()
        {
            return "Apollo";
        }
    }
    class Wockhardt : Hospital
    {
        public override String HospitalDetails()
        {
            return "Wockhardt";
        }
    }
    class Gokul_Superspeciality : Hospital
    {
        public override String HospitalDetails()
        {
            return "Gokul_Superspeciality";
        }
    }
}
