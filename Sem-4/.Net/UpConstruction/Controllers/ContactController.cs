using Microsoft.AspNetCore.Mvc;

namespace UpConstruction.Controllers
{
    public class ContactController : Controller
    {
        public IActionResult Contact()
        {
            return View();
        }
    }
}
