using CRUDAPIDemo.Models;
using Microsoft.AspNetCore.Mvc;

namespace CRUDAPIDemo.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class DoctorAPIController : Controller
    {
        private readonly HospitalManagementContext context;
        public DoctorAPIController(HospitalManagementContext _context)
        {
            context = _context;
        }

        [HttpGet("failure")]
        public IActionResult GetFailure()
        {
            throw new Exception("This is a failure message from the middleware.");
        }

        #region GetAllDoctors
        [HttpGet]
        public IActionResult GetAllDoctor()
        {
            var doctor = context.Doctors.ToList();
            return Ok(doctor);
        }
        #endregion

        #region GetDoctorById
        [HttpGet("{id}")]
        public IActionResult GetDoctorById(int id)
        {
            var doctor = context.Doctors.Find(id);
            if (doctor == null)
            {
                return NotFound();
            }
            return Ok(doctor);
        }
        #endregion

        #region InsertDoctor
        [HttpPost]
        public IActionResult InsertDoctor(Doctor doctor)
        {
            context.Doctors.Add(doctor);
            context.SaveChanges();
            return CreatedAtAction(nameof(GetDoctorById), new { id = doctor.DoctorId }, doctor);
        }
        #endregion

        #region UpdateDoctor
        [HttpPut("{id}")]
        public IActionResult UpdateDoctor(int id, Doctor doctor)
        {
            if (id != doctor.DoctorId)
            {
                return BadRequest();
            }
            else
            {
                var existingDoctor = context.Doctors.Find(id);
                if (existingDoctor == null)
                {
                    return NotFound();
                }
                existingDoctor.DoctorName = doctor.DoctorName;
                existingDoctor.Degree = doctor.Degree;
                existingDoctor.Experience = doctor.Experience;
                existingDoctor.Specialization = doctor.Specialization;
                existingDoctor.Age = doctor.Age;
                existingDoctor.Dob = doctor.Dob;
                context.Doctors.Update(existingDoctor);
                context.SaveChanges();
                return NoContent();
            }
        }
            #endregion

        #region DeleteDoctorById
            [HttpDelete("{id}")]
            public IActionResult DeleteDoctorById(int id)
            {
                var doctor = context.Doctors.Find(id);
                if(doctor == null)
                {
                    return NotFound();
                }
                context.Doctors.Remove(doctor);
                context.SaveChanges();
                return NoContent();
            }
            #endregion
        }
    }
