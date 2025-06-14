namespace MVC_Lab_6._1.Models
{
    public class Hospital_API_ConsumeModel
    {
        public int HospitalId { get; set; }

        public string HospitalName { get; set; } = null!;

        public string HospitalAddress { get; set; } = null!;

        public string? ContactNumber { get; set; }

        public string? EmailAddress { get; set; }

        public string OwnerName { get; set; } = null!;

        public DateTime OpeningDate { get; set; }

        public int TotalStaffs { get; set; }

        public bool SundayOpen { get; set; }
    }
}
