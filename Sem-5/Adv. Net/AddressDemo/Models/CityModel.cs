using System.ComponentModel;
using System.ComponentModel.DataAnnotations;

namespace AddressDemo.Models
{
    public class CityModel
    {
        public int? CityID { get; set; }
        [Required]
        [DisplayName("City Name")]
        public string? CityName { get; set; }
        [Required]
        [DisplayName("Country Name")]
        public int CountryID { get; set; }
        [Required]
        [DisplayName("State Name")]
        public int StateID { get; set; }
        [Required]
        public string StateName { get; set; }
        [Required]
        [DisplayName("STD Code")]
        public string? STDCode { get; set; }
    }

    public class CountryDropDownModel
    {
        public int CountryID { get; set; }
        public string CountryName { get; set; }
    }

    public class StateDropDownModel
    {
        public int StateID { get; set; }
        public string StateName { get; set; }
    }
}
