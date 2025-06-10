using CRUDAPIDemo.Models;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace CRUDAPIDemo.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class HospitalAPIController : ControllerBase
    {
        private readonly HospitalManagementContext context;
        public HospitalAPIController(HospitalManagementContext _context)
        {
            context = _context;
        }

        #region GetAllHospital
        [HttpGet]
        public IActionResult GetAllHospital() {
            var hospital = context.HospitalMasters.ToList();
            return Ok(hospital);
        }
        #endregion

        #region GetHospitalById
        [HttpGet("{id}")]
        public IActionResult GetHospitalById(int id)
        {
            var hospital = context.HospitalMasters.Find(id);
            if(hospital == null)
            {
                return NotFound();
            }
            return Ok(hospital);
        }
        #endregion

        #region DeleteHospitalById
        [HttpDelete("{id}")]
        public IActionResult DeleteHospitalById(int id)
        {
            var hospital = context.HospitalMasters.Find(id);
            if (hospital == null)
            {
                return NotFound();
            }
            context.HospitalMasters.Remove(hospital);
            context.SaveChanges();
            return NoContent();
        }
        #endregion

        #region InsertHospital
        [HttpPost]
        public IActionResult InsertHospital(HospitalMaster hospital)
        {
            context.HospitalMasters.Add(hospital);
            context.SaveChanges();
            return NoContent();
        }
        #endregion

        #region UpdateHospital
        [HttpPut("{id}")]
        public IActionResult UpdateHospital(int id,HospitalMaster hospital)
        {
            if (id != hospital.HospitalId)
            {
                return BadRequest();
            }
            var existingHospital =context.HospitalMasters.Find(id);
            if(existingHospital == null)
            {
                return NotFound();
            }
            existingHospital.HospitalId = hospital.HospitalId;
            existingHospital.HospitalName = hospital.HospitalName;
            existingHospital.HospitalAddress = hospital.HospitalAddress;
            existingHospital.ContactNumber = hospital.ContactNumber;
            existingHospital.EmailAddress = hospital.EmailAddress;
            existingHospital.OwnerName = hospital.OwnerName;
            existingHospital.OpeningDate = hospital.OpeningDate;
            existingHospital.TotalStaffs = hospital.TotalStaffs;
            existingHospital.SundayOpen = hospital.SundayOpen;

            context.HospitalMasters.Update(existingHospital);
            context.SaveChanges();
            return NoContent();
        }
        #endregion
    }
}
