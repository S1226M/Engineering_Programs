using System.Data;
using System.Data.SqlClient;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Configuration;

namespace Demo.Controllers
{
    public class EmployeeController : Controller
    {
        public IConfiguration configuration;
        public EmployeeController(IConfiguration _configuration)
        {
            configuration = _configuration;
        }
        #region Quiz List

        #endregion Quiz List
        public IActionResult EmployeeSelectAll()
        {
            string connectionString = configuration.GetConnectionString("ConnectionString");
            SqlConnection connection = new SqlConnection(connectionString);
            connection.Open();
            SqlCommand command = connection.CreateCommand();
            command.CommandType = CommandType.StoredProcedure;
            command.CommandText = "PR_SELECTALL_EMPLOYEE";
            SqlDataReader reader = command.ExecuteReader();
            DataTable table = new DataTable();
            table.Load(reader);
            return View(table);
        }
    }
}
