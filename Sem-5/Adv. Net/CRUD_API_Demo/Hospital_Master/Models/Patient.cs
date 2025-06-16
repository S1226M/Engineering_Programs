namespace CRUDAPIDemo.Models
{
    public partial class Patient
    {
        public int PatientId { get; set; }

        public string PatientName { get; set; } = null!;

        public string ContactNumber { get; set; } = null!;

        public int Age { get; set; }

        public bool EarlierOperation { get; set; }

        public string BloodGroup { get; set; } = null!;
    }
}
