using System;
using System.Collections.Generic;
using System.Text.Json.Serialization;

namespace DemoAPI.Models;

public partial class Category
{
    [JsonIgnore]
    public int CategoryId { get; set; }

    public string CategoryName { get; set; } = null!;

    public string? Description { get; set; }
    [JsonIgnore]
    public virtual ICollection<Product> Products { get; set; } = new List<Product>();
}
