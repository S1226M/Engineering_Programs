using Microsoft.AspNetCore.Mvc;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text.Json.Serialization;

namespace MovieApi.Controllers
{
    public class Movie
    {
        [JsonIgnore]
        public int Id { get; set; }

        [Required]
        public string Title { get; set; }

        [Required]
        public string Director { get; set; }

        [Range(1888, 2024)] 
        public int ReleaseYear { get; set; }

        public string Genre { get; set; }
    }

    [ApiController]
    [Route("api/[controller]")]
    public class MoviesController : ControllerBase
    {
        private static List<Movie> _movies = new List<Movie>
        {
            new Movie { Id = 1, Title = "ABC", Director = "Smit", ReleaseYear = 2025, Genre = "AAA" },
            new Movie { Id = 2, Title = "BCD", Director = "Shyam", ReleaseYear = 2026, Genre = "BBB" },
            new Movie { Id = 3, Title = "CDE", Director = "Avi", ReleaseYear = 2027, Genre = "CCC" },
            new Movie { Id = 4, Title = "DEF", Director = "Jainil", ReleaseYear = 2028, Genre = "DDD" }

        };

        static int _nextId = _movies.Max(m => m.Id) + 1;

        [HttpGet]
        public IActionResult GetAllMovies()
        {
            return Ok(_movies);
        }

        [HttpGet("{id}")]
        public IActionResult GetMovieById(int id)
        {
            var movie = _movies.FirstOrDefault(m => m.Id == id);
            if (movie == null)
                return NotFound();

            return Ok(movie);
        }

        [HttpPost]
        public IActionResult CreateMovie([FromBody] Movie newMovie)
        {
            if (!ModelState.IsValid)
                return BadRequest(ModelState);

            newMovie.Id = _nextId++;
            _movies.Add(newMovie);

            return CreatedAtAction(nameof(GetMovieById), new { id = newMovie.Id }, newMovie);
        }

        [HttpPut("{id}")]
        public IActionResult UpdateMovie(int id, [FromBody] Movie updatedMovie)
        {
            if (id != updatedMovie.Id)
                return BadRequest("Id mismatch.");

            if (!ModelState.IsValid)
                return BadRequest(ModelState);

            var existingMovie = _movies.FirstOrDefault(m => m.Id == id);
            if (existingMovie == null)
                return NotFound();

            existingMovie.Title = updatedMovie.Title;
            existingMovie.Director = updatedMovie.Director;
            existingMovie.ReleaseYear = updatedMovie.ReleaseYear;
            existingMovie.Genre = updatedMovie.Genre;

            return NoContent();
        }

        [HttpDelete("{id}")]
        public IActionResult DeleteMovie(int id)
        {
            var movie = _movies.FirstOrDefault(m => m.Id == id);
            if (movie == null)
                return NotFound();

            _movies.Remove(movie);
            return NoContent();
        }
    }
}
