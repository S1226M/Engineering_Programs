using System.Collections;

using Class_Pratice;

List<Student> GetAllStudent()
{
    List<Student> student = new List<Student>();
    student.Add(new Student { Rno = 1, Name = "John", Age = "20", Branch = "CSE", CPI = 8.5f , sem = 1});
    student.Add(new Student { Rno = 1, Name = "John", Age = "20", Branch = "CSE", CPI = 9.5f, sem = 3 });
    student.Add(new Student { Rno = 2, Name = "ASDE", Age = "21", Branch = "ECE", CPI = 9.0f , sem = 3 });
    student.Add(new Student { Rno = 3, Name = "Alice", Age = "22", Branch = "ME", CPI = 7.5f , sem = 8 });
    student.Add(new Student { Rno = 4, Name = "Bob", Age = "23", Branch = "CSE", CPI = 8.0f , sem = 6 });
    
    return student;
}

Console.WriteLine("--------------------------- All Students -----------------------");
var students = GetAllStudent();
foreach (Student student in students)
{
    Console.WriteLine($"Rno: {student.Rno}, Name: {student.Name}, Age: {student.Age}, Branch: {student.Branch}, CPI: {student.CPI}, sem: {student.sem}");
}

Console.WriteLine("--------------------------- > 8 -----------------------");
var Greterthen = students.Where(s => s.CPI > 8.0f).ToList();
foreach (Student student in Greterthen)
{
    Console.WriteLine($"Rno: {student.Rno}, Name: {student.Name}, Age: {student.Age}, Branch: {student.Branch}, CPI: {student.CPI}, sem: {student.sem}");
}

Console.WriteLine("------------------------- < 8 -------------------------");
var LessThan = students.Where(s => s.CPI < 8.0f).ToList();
foreach (Student student in LessThan)
{
    Console.WriteLine($"Rno: {student.Rno}, Name: {student.Name}, Age: {student.Age}, Branch: {student.Branch}, CPI: {student.CPI}, sem: {student.sem}");
}

Console.WriteLine("-------------------------- > 8 | < 7------------------------");
var Between = students.Where(s => s.CPI > 8.0f && s.CPI < 8.0f);
foreach (Student student in Between)
{
    Console.WriteLine($"Rno: {student.Rno}, Name: {student.Name}, Age: {student.Age}, Branch: {student.Branch}, CPI: {student.CPI}, sem: {student.sem}");
}

Console.WriteLine("-------------------------- Sem 3 And CPI > 8 ------------------------");
var stu = students.Where(s => s.sem == 3 && s.CPI > 8.0f).ToList();
foreach (Student student in stu)
{
    Console.WriteLine($"Rno: {student.Rno}, Name: {student.Name}, Age: {student.Age}, Branch: {student.Branch}, CPI: {student.CPI}, sem: {student.sem}");
}

Console.WriteLine("-------------------------- Start With R ------------------------");
var startWithR = students.Where(s => s.Name.StartsWith("R")).ToList();
foreach (Student student in stu)
{
    Console.WriteLine($"Rno: {student.Rno}, Name: {student.Name}, Age: {student.Age}, Branch: {student.Branch}, CPI: {student.CPI}, sem: {student.sem}");
}

Console.WriteLine("-------------------------- Name contains E and Sem is 3 ------------------------");
var name = students.Where(s => s.Name.Contains("E") && s.sem == 3).ToList();
foreach (Student student in stu)
{
    Console.WriteLine($"Rno: {student.Rno}, Name: {student.Name}, Age: {student.Age}, Branch: {student.Branch}, CPI: {student.CPI}, sem: {student.sem}");
}

Console.WriteLine("--------------------- Name Contains E and and Sem 3 And Display only Rno , Name , Branch , Sem --------------------");
var studentName = students.Where(s => s.Name.Contains("E") && s.sem == 3)
    .Select(s => new { s.Rno, s.Name, s.Branch, s.sem }).ToList();
foreach (var student in studentName)
{
    Console.WriteLine($"Rno: {student.Rno}, Name: {student.Name}, Branch: {student.Branch}, sem: {student.sem}");
}

Console.WriteLine("-------------------------- Min CPI ------------------------");
var minCPI = students.Min(s => s.CPI);
Console.WriteLine($"Minimum CPI: {minCPI}");

Console.WriteLine("-------------------------- Max CPI ------------------------");
var maxCPI = students.Max(s => s.CPI);
Console.WriteLine($"Max CPI: {maxCPI}");

Console.WriteLine("-------------------------- Avg CPI ------------------------");
var avgCPI = students.Average(s => s.CPI);
Console.WriteLine($"AVG CPI: {avgCPI}");

Console.WriteLine("-------------------------- CPI > 8 and sem = 3 orderby Rno ------------------------");
var stu1 = students.Where(s => s.CPI > 8 && s.sem == 3).OrderBy(s => s.Rno).ToList();
foreach (var student in stu1)
{
    Console.WriteLine($"Rno: {student.Rno}, Name: {student.Name}, Age: {student.Age}, Branch: {student.Branch}, CPI: {student.CPI}, sem: {student.sem}");
}

Console.WriteLine("-------------------------- skip first 3 ------------------------");
var stu2 = students.Skip(3).Take(3);
foreach (var student in stu2)
{
    Console.WriteLine($"Rno: {student.Rno}, Name: {student.Name}, Age: {student.Age}, Branch: {student.Branch}, CPI: {student.CPI}, sem: {student.sem}");
}

Console.WriteLine("-------------------------- Group by Branch,sem and count of that ------------------------");
var stu3 = students.GroupBy(s => new { s.Branch, s.sem })
    .Select(g => new { g.Key.Branch, g.Key.sem, Count = g.Count() }).ToList();
foreach (var group in stu3)
{
    Console.WriteLine($"Branch: {group.Branch}, Sem: {group.sem}, Count: {group.Count}");
}

Console.WriteLine("-------------------------- Group by Branch,sem ------------------------");
var st = students.GroupBy(s => new { s.Branch, s.sem })
    .Select(g => new { g.Key.Branch, g.Key.sem, Students = g.ToList() }).ToList();
foreach (var group in st)
{
    Console.WriteLine($"Branch: {group.Branch}, Sem: {group.sem}");
    foreach (var student in group.Students)
    {
        Console.WriteLine($"  Rno: {student.Rno}, Name: {student.Name}, Age: {student.Age}, CPI: {student.CPI}");
    }
}