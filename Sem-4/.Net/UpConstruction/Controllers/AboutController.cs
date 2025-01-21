using Microsoft.AspNetCore.Mvc;

namespace UpConstruction.Controllers
{
    public class AboutController : Controller
    {
        public IActionResult About()
        {
            return View();
        }
    }
}
