using System.Data;
using System.Data.SqlClient;
using System.Diagnostics;
using AddressDemo.Models;
using Microsoft.AspNetCore.Mvc;

namespace AddressDemo.Controllers
{
    public class HomeController : Controller
    {
        private readonly ILogger<HomeController> _logger;
        private readonly IConfiguration configuration;

        public HomeController(ILogger<HomeController> logger,IConfiguration _configuration)
        {
            _logger = logger;
            configuration = _configuration;
        }

        public IActionResult Index()
        {
            string connectionstr = configuration.GetConnectionString("ConnectionString");
            SqlConnection conn = new SqlConnection(connectionstr);
            //PrePare a connection
            DataTable dt = new DataTable();
            conn.Open();

            //Prepare a Command
            SqlCommand objCmd = conn.CreateCommand();
            objCmd.CommandType = CommandType.StoredProcedure;
            objCmd.CommandText = "PR_LOC_TotalCount";

            SqlDataReader objSDR = objCmd.ExecuteReader();
            dt.Load(objSDR);
            conn.Close();
            return View("Index", dt);
        }

        public IActionResult Privacy()
        {
            return View();
        }

        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
        public IActionResult Error()
        {
            return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
        }
    }
}
