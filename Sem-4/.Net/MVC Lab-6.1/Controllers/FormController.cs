using Microsoft.AspNetCore.Mvc;

namespace MVC_Lab_6._1.Controllers
{
    public class FormController : Controller
    {
        public IActionResult Index()
        {
            return View();
        }
    }
}
