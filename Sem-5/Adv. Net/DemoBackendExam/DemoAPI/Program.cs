using DemoAPI.Models;
using Microsoft.EntityFrameworkCore;

var builder = WebApplication.CreateBuilder(args);

// 1. Extract the connection string first to check for nulls
var connectionString = builder.Configuration.GetConnectionString("DefaultConnectionString");

// 2. Guard Clause: This prevents the 'Parameter s' error by giving a clear message
if (string.IsNullOrEmpty(connectionString))
{
    throw new InvalidOperationException("Connection string 'DefaultConnectionString' not found in appsettings.json. Please check your configuration.");
}

// Add Services
builder.Services.AddControllers();
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

// DB Context Registration using the verified string
builder.Services.AddDbContext<DemoBackendApiContext>(options =>
    options.UseSqlServer(connectionString));

var app = builder.Build();

// Configure Middleware
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI(options =>
    {
        options.SwaggerEndpoint("/swagger/v1/swagger.json", "v1");
    });
}

app.UseAuthorization();
app.MapControllers();

app.Run();