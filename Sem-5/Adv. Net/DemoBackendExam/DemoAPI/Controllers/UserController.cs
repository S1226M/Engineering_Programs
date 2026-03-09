using Microsoft.AspNetCore.Mvc;

namespace DemoAPI.Controllers
{
    public class UserController : Controller
    {
        public IActionResult Index()
        {
            return View();
        }
    }
}
