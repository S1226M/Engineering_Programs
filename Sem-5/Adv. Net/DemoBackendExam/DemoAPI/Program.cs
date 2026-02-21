using DemoAPI.Models; // Ensure this matches your namespace
using Microsoft.EntityFrameworkCore;

var builder = WebApplication.CreateBuilder(args);

// Add Services
builder.Services.AddControllers();
builder.Services.AddEndpointsApiExplorer(); // Required for Swagger
builder.Services.AddSwaggerGen();           // Fixes 'AddSwaggerGen' error

// DB Context Registration
builder.Services.AddDbContext<DemoBackendApiContext>(options =>
    options.UseSqlServer(builder.Configuration.GetConnectionString("DefaultConnection")));

var app = builder.Build();

// Configure Middleware
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI(options =>
    {
        // Points Swagger to the internal JSON document
        options.SwaggerEndpoint("/swagger/v1/swagger.json", "v1");
    });
}

app.UseAuthorization();
app.MapControllers();
app.Run();