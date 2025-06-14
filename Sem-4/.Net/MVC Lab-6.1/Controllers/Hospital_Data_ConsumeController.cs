using Microsoft.AspNetCore.Mvc;
using MVC_Lab_6._1.Models;

namespace MVC_Lab_6._1.Controllers
{
    public class Hospital_Data_ConsumeController : Controller
    {
        Uri baseAddress = new Uri("http://localhost:0/api");
        private readonly HttpClient _client;

        public Hospital_Data_ConsumeController()
        {
            _client = new HttpClient();
            _client.BaseAddress = baseAddress;
        }

        [HttpGet]
        public IActionResult Index()
        {
            List< Hospital_API_ConsumeModel> hospitalData = new List<Hospital_API_ConsumeModel>();
            HttpResponse response = _client.GetAsync(_clint.BaseAddress"Hospital_Data_Consume").Result;
            return View();
        }
    }
}
