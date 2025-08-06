using System;
using Jose;

public static class VideoSDKTokenService
{
    public static string GenerateToken(string apiKey, string secret)
    {
        var payload = new
        {
            apikey = apiKey,
            permissions = new[] { "allow_join", "allow_mod" },
            exp = DateTimeOffset.UtcNow.AddHours(2).ToUnixTimeSeconds()
        };

        return JWT.Encode(payload, System.Text.Encoding.UTF8.GetBytes(secret), JwsAlgorithm.HS256);
    }
}
