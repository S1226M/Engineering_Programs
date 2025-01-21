using Microsoft.AspNetCore.Mvc;

namespace UpConstruction.Controllers
{
    public class BlogController : Controller
    {
        public IActionResult Blog()
        {
            return View();
        }
    }
}
