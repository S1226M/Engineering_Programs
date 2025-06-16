namespace CRUDAPIDemo.Models
{
    public partial class Doctor
    {
        public int DoctorId { get; set; }

        public string DoctorName { get; set; } = null!;

        public string Degree { get; set; } = null!;

        public string Experience { get; set; } = null!;

        public string Specialization { get; set; } = null!;

        public int Age { get; set; }

        public DateTime Dob { get; set; }
    }
}
