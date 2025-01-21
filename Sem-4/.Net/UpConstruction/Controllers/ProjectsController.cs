using Microsoft.AspNetCore.Mvc;

namespace UpConstruction.Controllers
{
    public class ProjectsController : Controller
    {
        public IActionResult Projects()
        {
            return View();
        }
    }
}
