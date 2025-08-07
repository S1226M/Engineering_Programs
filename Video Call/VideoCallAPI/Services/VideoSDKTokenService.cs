using System;
using System.IdentityModel.Tokens.Jwt;
using System.Security.Claims;
using System.Text;
using Microsoft.IdentityModel.Tokens;

namespace YourNamespace.Services
{
    public class VideoSDKTokenService
    {
        private readonly string _apiKey = "03dc1b4a-303c-4ee0-bd9d-5530ca30c4a4";
        private readonly string _secretKey = "65c41582a85f0543a0d174e051ae4feb93240edd2af98bd4c627985cb5a68228";

        public string GenerateToken()
        {
            var securityKey = new SymmetricSecurityKey(Encoding.UTF8.GetBytes(_secretKey));
            var credentials = new SigningCredentials(securityKey, SecurityAlgorithms.HmacSha256);

            var tokenDescriptor = new SecurityTokenDescriptor
            {
                Issuer = _apiKey,
                Expires = DateTime.UtcNow.AddHours(24),
                SigningCredentials = credentials
            };

            var tokenHandler = new JwtSecurityTokenHandler();
            var token = tokenHandler.CreateToken(tokenDescriptor);
            return tokenHandler.WriteToken(token);
        }
    }
}
