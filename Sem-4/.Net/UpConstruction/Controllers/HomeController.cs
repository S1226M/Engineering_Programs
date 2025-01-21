using System.Diagnostics;
using Microsoft.AspNetCore.Mvc;
using UpConstruction.Models;

namespace UpConstruction.Controllers
{
    public class HomeController : Controller
    {
        public IActionResult Home()
        {
            return View();
        }
    }
}
