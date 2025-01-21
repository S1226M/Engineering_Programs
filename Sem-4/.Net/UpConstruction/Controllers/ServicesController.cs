using Microsoft.AspNetCore.Mvc;

namespace UpConstruction.Controllers
{
    public class ServicesController : Controller
    {
        public IActionResult Services()
        {
            return View();
        }
    }
}
