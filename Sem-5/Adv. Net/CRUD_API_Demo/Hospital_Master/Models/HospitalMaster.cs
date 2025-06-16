using System;
using System.Collections.Generic;

namespace CRUDAPIDemo.Models;

public partial class HospitalMaster
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
