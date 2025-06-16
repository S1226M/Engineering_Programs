using CRUDAPIDemo.Models;
using Microsoft.AspNetCore.Mvc;

namespace CRUDAPIDemo.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class PatientAPIController : Controller
    {
        private readonly HospitalManagementContext context;
        public PatientAPIController(HospitalManagementContext _context)
        {
            context = _context;
        }

        #region GetAllPatients
        [HttpGet]
        public IActionResult GetAllPatient()
        {
            var patient = context.Patients.ToList();
            return Ok(patient);
        }
        #endregion

        #region GetPatientById
        [HttpGet("{id}")]
        public IActionResult PatientGetById(int id)
        {
            var patient = context.Patients.Find(id);
            if (patient == null)
            {
                return NotFound();
            }
            return Ok(patient);
        }
        #endregion

        #region InsertPatient
        [HttpPost]
        public IActionResult InsertPatient(Patient patient)
        {
            context.Patients.Add(patient);
            context.SaveChanges();
            return CreatedAtAction(nameof(PatientGetById), new { id = patient.PatientId }, patient);
        }
        #endregion

        #region UpdatePatient
        [HttpPut("{id}")]
        public IActionResult UpdatePatient(int id, Patient patient)
        {
            if (id != patient.PatientId)
            {
                return BadRequest();
            }
            else
            {
                var existingPatient = context.Patients.Find(id);
                if (existingPatient == null)
                {
                    return NotFound();
                }
                else
                {
                    existingPatient.PatientName = patient.PatientName;
                    existingPatient.ContactNumber = patient.ContactNumber;
                    existingPatient.Age = patient.Age;
                    existingPatient.EarlierOperation = patient.EarlierOperation;
                    existingPatient.BloodGroup = patient.BloodGroup;
                    context.SaveChanges();
                    return NoContent();
                }
            }
        }
        #endregion

        #region DeletePatientById
        [HttpDelete("{id}")]
        public IActionResult PatientDelete(int id)
        {
            var patient = context.Patients.Find(id);
            if (patient == null)
            {
                return NotFound();
            }
            context.Patients.Remove(patient);
            context.SaveChanges();
            return NoContent();
        }
        #endregion
    }
}
