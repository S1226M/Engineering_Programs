using Microsoft.AspNetCore.Mvc;
using YourNamespace.Services;

namespace YourNamespace.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class VideoSDKController : ControllerBase
    {
        private readonly VideoSDKTokenService _tokenService;

        public VideoSDKController(VideoSDKTokenService tokenService)
        {
            _tokenService = tokenService;
        }

        [HttpGet]
        public IActionResult GetToken()
        {
            var token = _tokenService.GenerateToken();
            return Ok(new { token });
        }
    }
}
