using DemoAPI.Models;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using System.Runtime.InteropServices;
using System.Threading.Tasks;

namespace DemoAPI.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class CategoryController : Controller
    {
        private readonly DemoBackendApiContext context;
        public CategoryController(DemoBackendApiContext _context)
        {
            context = _context;
        }

        [HttpGet]
        public async Task<IActionResult> CategoriesListPage()
        {
            var categories = await context.Categories.ToListAsync();
            return Ok(categories);
        }

        [HttpGet("{id}")]
        public async Task<IActionResult> CategoriesByID(int id)
        {
            var categories = await context.Categories.FindAsync(id);
            if (categories == null) return NotFound();
            return Ok(categories);
        }

        [HttpPost]
        public async Task<IActionResult> CategoryInsert([FromBody] Category category)
        {
            if (category == null) return BadRequest("Category data is null.");
            context.Add(category);
            await context.SaveChangesAsync();
            return Ok("Categories Added Secussefully");
        }

        [HttpPut("{id}")]
        public async Task<IActionResult> CategoryUpdate(int id,[FromBody] Category category)
        
        {
            var existingCategory = await context.Categories.FindAsync(id);

            existingCategory.CategoryName = category.CategoryName;
            existingCategory.Description = category.CategoryName;

            await context.SaveChangesAsync();
            return Ok(existingCategory);
        }

        [HttpDelete("{id}")]
        public async Task<IActionResult> CategoryDelete(int id)
        {
            var category = await context.Categories.FindAsync(id);

            if (category == null) return NotFound($"Category with ID {id} was not found.");

            context.Categories.Remove(category);
            await context.SaveChangesAsync();
            return NoContent();
        }
    }
}
