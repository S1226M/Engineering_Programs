using Microsoft.AspNetCore.Mvc;
using System.Net.Http.Headers;
using HospitalHubVideoCall_API.Models;

namespace HospitalHubVideoCall_API.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class VideoSDKController : ControllerBase
    {
        private readonly IConfiguration _config;
        public VideoSDKController(IConfiguration config)
        {
            _config = config;
        }

        [HttpGet("token")]
        public IActionResult GetToken()
        {
            try
            {
                var apiKey = _config["VideoSDK:APIKey"];
                var secretKey = _config["VideoSDK:SecretKey"];

                if (string.IsNullOrEmpty(apiKey) || string.IsNullOrEmpty(secretKey))
                {
                    return BadRequest(new { error = "VideoSDK API credentials not configured" });
                }

                // Simple token using JWT generation
                var token = VideoSDKTokenService.GenerateToken(apiKey, secretKey);
                return Ok(new { token });
            }
            catch (Exception ex)
            {
                return StatusCode(500, new { error = "Failed to generate token", details = ex.Message });
            }
        }

        [HttpPost("create-meeting")]
        public async Task<IActionResult> CreateMeeting([FromBody] CreateMeetingRequest request)
        {
            try
            {
                var apiKey = _config["VideoSDK:APIKey"];
                var secretKey = _config["VideoSDK:SecretKey"];

                if (string.IsNullOrEmpty(apiKey) || string.IsNullOrEmpty(secretKey))
                {
                    return BadRequest(new { error = "VideoSDK API credentials not configured" });
                }

                // Generate token for meeting creation
                var token = VideoSDKTokenService.GenerateToken(apiKey, secretKey);
                
                // Generate a random meeting ID
                var meetingId = Guid.NewGuid().ToString("N")[..10];
                
                return Ok(new { 
                    meetingId = meetingId,
                    token = token,
                    message = "Meeting created successfully"
                });
            }
            catch (Exception ex)
            {
                return StatusCode(500, new { error = "Failed to create meeting", details = ex.Message });
            }
        }
        
        [HttpGet("validate-meeting/{meetingId}")]
        public IActionResult ValidateMeeting(string meetingId)
        {
            try
            {
                if (string.IsNullOrEmpty(meetingId))
                {
                    return BadRequest(new { error = "Meeting ID is required" });
                }
                
                // In a real application, you would validate against your database
                // For this demo, we'll accept any non-empty meeting ID
                return Ok(new { 
                    valid = true, 
                    meetingId = meetingId,
                    message = "Meeting ID is valid" 
                });
            }
            catch (Exception ex)
            {
                return StatusCode(500, new { error = "Failed to validate meeting", details = ex.Message });
            }
        }
    }
}
