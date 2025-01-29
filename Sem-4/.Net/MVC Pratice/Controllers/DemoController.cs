using Microsoft.AspNetCore.Mvc;

namespace MVC_Pratice.Controllers
{
    public class DemoController : Controller
    {
        public IActionResult Index()
        {
            return View();
        }
    }
}
