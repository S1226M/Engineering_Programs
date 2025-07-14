using Microsoft.AspNetCore.Mvc;

namespace VersionedApiDemo.Controllers.v1
{
    [ApiVersion("1.0")]
    [Route("api/v{version:apiVersion}/[controller]")]
    [ApiController]
    public class ProductController : ControllerBase
    {
        [HttpGet]
        public IActionResult Get() =>
            Ok(new { Version = "1.0", Product = "Coffee Mug" });
    }
}