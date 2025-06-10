using System.Data.SqlClient;
using System.Data;
using Microsoft.AspNetCore.Mvc;

namespace Count_OF_Three_Demo.Controllers
{
    public class CountDemoController : Controller
    {
        public IConfiguration configuration;
        public CountDemoController(IConfiguration _configuration)
        {
            configuration = _configuration;
        }
        public IActionResult CountView()
        {
            string connectionString = configuration.GetConnectionString("ConnectionString");
            SqlConnection connection = new SqlConnection(connectionString);
            connection.Open();
            SqlCommand command = connection.CreateCommand();
            command.CommandType = CommandType.StoredProcedure;
            command.CommandText = "PR_Count_Of_Three";
            SqlDataReader reader = command.ExecuteReader();
            DataTable table = new DataTable();
            table.Load(reader);
            return View(table);
        }
    }
}
