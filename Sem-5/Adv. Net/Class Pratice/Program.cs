using System.Collections;
using System.Collections.Generic;
using System.Linq;
using Class_Pratice;

List<Student> GetAllStudent()
{
    List<Student> student = new List<Student>();
    student.Add(new Student { Rno = 001, Name = "John", Age = 20, Branch = "CSE", CPI = 8.5f , sem = 1});
    student.Add(new Student { Rno = 002, Name = "John", Age = 20, Branch = "CSE", CPI = 9.5f, sem = 3 });
    student.Add(new Student { Rno = 003, Name = "ASDE", Age = 21, Branch = "ECE", CPI = 9.0f , sem = 3 });
    student.Add(new Student { Rno = 004, Name = "Alice", Age = 22, Branch = "ME", CPI = 7.5f , sem = 8 });
    student.Add(new Student { Rno = 005, Name = "Bob", Age = 23, Branch = "CSE", CPI = 8.0f , sem = 6 });
    student.Add(new Student { Rno = 101, Name = "Ramesh", Age = 23, Branch = "CE", CPI = 9.2f, sem = 3 });
    student.Add(new Student { Rno = 102, Name = "Mahesh", Age = 21, Branch = "EC", CPI = 8.8f, sem = 3 });
    student.Add(new Student { Rno = 103, Name = "Suresh", Age = 22, Branch = "ME", CPI = 7.5f, sem = 4 });
    student.Add(new Student { Rno = 104, Name = "Amit", Age = 20, Branch = "EE", CPI = 8.6f, sem = 4 });
    student.Add(new Student { Rno = 105, Name = "Anita", Age = 22, Branch = "CE", CPI = 8.0f, sem = 4 });
    student.Add(new Student { Rno = 106, Name = "Reeta", Age = 21, Branch = "ME", CPI = 7.35f, sem = 3 });
    student.Add(new Student { Rno = 107, Name = "Rohit", Age = 24, Branch = "EE", CPI = 9.45f, sem = 4 });
    student.Add(new Student { Rno = 108, Name = "Chetan", Age = 26, Branch = "CE", CPI = 8.6f, sem = 3 });
    student.Add(new Student { Rno = 109, Name = "Rakesh", Age = 24, Branch = "CE", CPI = 9.10f, sem = 4 });
    student.Add(new Student { Rno = 110, Name = "Alice", Age = 20, Branch = "CSE", CPI = 8.5f, sem = 4 });
    student.Add(new Student { Rno = 111, Name = "Jay", Age = 21, Branch = "CE", CPI = 6.5f, sem = 5 });
    student.Add(new Student { Rno = 112, Name = "Vijay", Age = 22, Branch = "ME", CPI = 5.5f, sem = 4 });
    student.Add(new Student { Rno = 113, Name = "Rajvi", Age = 19, Branch = "CSE", CPI = 5.5f, sem = 5 });
    student.Add(new Student { Rno = 114, Name = "Viru", Age = 24, Branch = "ME", CPI = 8.5f, sem = 4 });
    student.Add(new Student { Rno = 115, Name = "Amee", Age = 24, Branch = "ME", CPI = 8.5f, sem = 5 });

    return student;
}

List<Department> GetAllDepartments()
{
    List<Department> department = new List<Department>();

    department.Add(new Department { BranchCode = "CSE", DepartmentName = "Computer Science", HOD = "Dr. Sharma" });
    department.Add(new Department { BranchCode = "ECE", DepartmentName = "Electronics", HOD = "Dr. Patel" });
    department.Add(new Department { BranchCode = "ME", DepartmentName = "Mechanical", HOD = "Dr. Rao" });
    department.Add(new Department { BranchCode = "CE", DepartmentName = "Civil", HOD = "Dr. Reddy" });
    department.Add(new Department { BranchCode = "EC", DepartmentName = "Electronics & Comm", HOD = "Dr. Mehta" });
    department.Add(new Department { BranchCode = "EE", DepartmentName = "Electrical", HOD = "Dr. Iyer" });
    return department;
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

Console.WriteLine("-------------------------- sem 3 And CPI > 8 ------------------------");
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

Console.WriteLine("-------------------------- Name contains E and sem is 3 ------------------------");
var name = students.Where(s => s.Name.Contains("E") && s.sem == 3).ToList();
foreach (Student student in stu)
{
    Console.WriteLine($"Rno: {student.Rno}, Name: {student.Name}, Age: {student.Age}, Branch: {student.Branch}, CPI: {student.CPI}, sem: {student.sem}");
}

Console.WriteLine("--------------------- Name Contains E and and sem 3 And Display only Rno , Name , Branch , sem --------------------");
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
    Console.WriteLine($"Branch: {group.Branch}, sem: {group.sem}, Count: {group.Count}");
}

Console.WriteLine("-------------------------- Group by Branch,sem ------------------------");
var st = students.GroupBy(s => new { s.Branch, s.sem })
    .Select(g => new { g.Key.Branch, g.Key.sem, Students = g.ToList() }).ToList();
foreach (var group in st)
{
    Console.WriteLine($"Branch: {group.Branch}, sem: {group.sem}");
    foreach (var student in group.Students)
    {
        Console.WriteLine($"  Rno: {student.Rno}, Name: {student.Name}, Age: {student.Age}, CPI: {student.CPI}");
    }
}

Console.WriteLine("-------------------------- Branch is CE ------------------------");
var stud1 = students.Where(s => s.Branch == "CE").ToList();
foreach (var student in stud1)
{
    Console.WriteLine($"Rno: {student.Rno}, Name: {student.Name}, Age: {student.Age}, Branch: {student.Branch}, CPI: {student.CPI}, sem: {student.sem}");
}
Console.WriteLine("-------------------------- CPI Greater Than 8.5 ------------------------");
var stud2 = students.Where(s => s.CPI > 8).ToList();
foreach (var student in stud1)
{
    Console.WriteLine($"Rno: {student.Rno}, Name: {student.Name}, Age: {student.Age}, Branch: {student.Branch}, CPI: {student.CPI}, sem: {student.sem}");
}
Console.WriteLine("-------------------------- Age Between 20 and 23 ------------------------");
var stud3 = students.Where(s => s.Age >= 20 && s.Age < 23).ToList();
foreach (var student in stud3)
{
    Console.WriteLine($"Rno: {student.Rno}, Name: {student.Name}, Age: {student.Age}, Branch: {student.Branch}, CPI: {student.CPI}, sem: {student.sem}");
}
Console.WriteLine("-------------------------- Semester is 4 and CPI > 8 ------------------------");
var stud4 = students.Where(s => s.sem == 4 && s.CPI > 8).ToList();
foreach (var student in stud4)
{
    Console.WriteLine($"Rno: {student.Rno}, Name: {student.Name}, Age: {student.Age}, Branch: {student.Branch}, CPI: {student.CPI}, sem: {student.sem}");
}
Console.WriteLine("-------------------------- Name Ends With H ------------------------");
var stud5 = students.Where(s => s.Name.EndsWith("h")).ToList();
foreach (var student in stud5)
{
    Console.WriteLine($"Rno: {student.Rno}, Name: {student.Name}, Age: {student.Age}, Branch: {student.Branch}, CPI: {student.CPI}, sem: {student.sem}");
}
Console.WriteLine("-------------------------- ME Branch and CPI < 7.5 ------------------------");
var stud6 = students.Where(s => s.Branch == "ME" && s.CPI < 7.5f).ToList();
foreach (var student in stud6)
{
    Console.WriteLine($"Rno: {student.Rno}, Name: {student.Name}, Age: {student.Age}, Branch: {student.Branch}, CPI: {student.CPI}, sem: {student.sem}");
}
Console.WriteLine("-------------------------- Students Sorted By Name ------------------------");
var stud7 = GetAllStudent().OrderBy(s => s.Name).ToList();
foreach (var student in stud7)
{
    Console.WriteLine($"Rno: {student.Rno}, Name: {student.Name}, Age: {student.Age}, Branch: {student.Branch}, CPI: {student.CPI}, sem: {student.sem}");
}
Console.WriteLine("-------------------------- Students Sorted By CPI Descending ------------------------");
var stud8 = GetAllStudent().OrderByDescending(s => s.CPI).ToList();
foreach (var student in stud8)
{
    Console.WriteLine($"Rno: {student.Rno}, Name: {student.Name}, Age: {student.Age}, Branch: {student.Branch}, CPI: {student.CPI}, sem: {student.sem}");
}
Console.WriteLine("-------------------------- Count of Students in Each Branch ------------------------");
var stud9 = students.GroupBy(s => s.Branch).Select(g => new { Branch = g.Key, count = g.Count() }).ToList();
foreach (var group in stud9)
{
    Console.WriteLine($"Branch: {group.Branch}, Count: {group.count}");
}
Console.WriteLine("-------------------------- Max CPI Student ------------------------");
var tempSTU10 = students.Max(s => s.CPI);
var stud10 = students.Where(s => s.CPI == tempSTU10);
foreach (var s in stud10)
{
    Console.WriteLine($"Rno: {s.Rno}, Name: {s.Name}, CPI: {s.CPI}, Branch: {s.Branch}");
}
Console.WriteLine("-------------------------- Min CPI in CE Branch ------------------------");
var tempSTU11 = students.Min(s => s.CPI);
var stud11 = students.Where(s => s.CPI == tempSTU10);
foreach (var s in stud11)
{
    Console.WriteLine($"Rno: {s.Rno}, Name: {s.Name}, CPI: {s.CPI}, Branch: {s.Branch}");
}
Console.WriteLine("-------------------------- Students Grouped By Semester ------------------------");
var stud12 = students.GroupBy(s => s.sem).ToList();
foreach (var group in stud12)
{
    Console.WriteLine($"\nSemester: {group.Key}");

    foreach (var s in group)
    {
        Console.WriteLine($"Rno: {s.Rno}, Name: {s.Name}, CPI: {s.CPI}, Branch: {s.Branch}");
    }
}
Console.WriteLine("-------------------------- Top 3 Students by CPI ------------------------");
var stud13 = students.OrderByDescending(s => s.CPI).Take(3);
foreach (var s in stud13)
{
    Console.WriteLine($"Rno: {s.Rno}, Name: {s.Name}, CPI: {s.CPI}, Branch: {s.Branch}");
}
Console.WriteLine("-------------------------- Skip First 5 Students ------------------------");
var stud14 = students.Skip(5);
foreach (var s in stud14)
{
    Console.WriteLine($"Rno: {s.Rno}, Name: {s.Name}, CPI: {s.CPI}, Branch: {s.Branch}");
}
Console.WriteLine("-------------------------- Take First 5 Students ------------------------");
var stud15 = students.Take(5);
foreach (var s in stud15)
{
    Console.WriteLine($"Rno: {s.Rno}, Name: {s.Name}, CPI: {s.CPI}, Branch: {s.Branch}");
}
Console.WriteLine("-------------------------- Select Only Names of Students ------------------------");
var stud16 = students.Select(s => s.Name).ToList();
foreach (var s in stud16)
{
    Console.WriteLine(s);
}
Console.WriteLine("-------------------------- Select Name and CPI Only ------------------------");
var stud17 = students.Select(s => new { s.Name , s.CPI}).ToList();
foreach (var s in stud17)
{
    Console.WriteLine($"Name : {s.Name} , CPI : {s.CPI}");
}
Console.WriteLine("-------------------------- Select Distinct Branches ------------------------");
var stud18 = students.Select(s => s.Branch).Distinct().ToList();
foreach (var s in stud18)
{
    Console.WriteLine(s);
}
Console.WriteLine("-------------------------- Any Student in CSE Branch ------------------------");
var stud19 = students.Any(s => s.Branch == "CSE");
Console.WriteLine(stud19);
Console.WriteLine("-------------------------- Count of Students in Each Branch ------------------------");
var stud20 = students.GroupBy(s => s.Branch).Select(g => new { Branch = g.Key , count = g.Count() }).ToList();
foreach (var group in stud20)
{
    Console.WriteLine($"Branch: {group.Branch}, Count: {group.count}");
}
Console.WriteLine("-------------------------- Group Students by Branch ------------------------");
var stud21 = students.GroupBy(s => s.Branch).Select(g => new {Branch = g.Key , Students = g.ToList() }).ToList();
foreach(var group in stud21)
{
    Console.WriteLine($"Branch: {group.Branch}");
    foreach (var student in group.Students)
    {
        Console.WriteLine($"  Rno: {student.Rno}, Name: {student.Name}, Age: {student.Age}, CPI: {student.CPI}, sem: {student.sem}");
    }
}
Console.WriteLine("-------------------------- Group Students by Semester ------------------------");
var stud22 = students.GroupBy(s => s.sem).Select(g => new { Semester = g.Key, Students = g.ToList() }).ToList();
foreach (var group in stud22)
{
    Console.WriteLine($"Semester: {group.Semester}");
    foreach (var student in group.Students)
    {
        Console.WriteLine($"  Rno: {student.Rno}, Name: {student.Name}, Age: {student.Age}, Branch: {student.Branch}, CPI: {student.CPI}");
    }
}
Console.WriteLine("-------------------------- Average CPI of All Students ------------------------");
var stud23 = students.Average(s => s.CPI);
Console.WriteLine($"Average CPI: {stud23}");
Console.WriteLine("-------------------------- Average CPI of All Students By Branch ------------------------");
var stud24 = students.GroupBy(s => s.Branch).Select( g => new {Branch = g.Key , AvgCPI = g.Average(s=> s.CPI) }).ToList();
foreach (var group in stud24)
{
    Console.WriteLine($"Branch: {group.Branch}, Average CPI: {group.AvgCPI}");
}
Console.WriteLine("-------------------------- Average CPI of All Students By Branch and Sem ------------------------");
var stud25 = students.GroupBy(s => new { s.Branch , s.sem}).Select(g => new { Branch = g.Key , sem = g.Key , AvgCPI = g.Average(s => s.CPI) }).ToList();
foreach (var group in stud25)
{
    Console.WriteLine($"Branch: {group.Branch}, Sem: {group.sem} , Average CPI: {group.AvgCPI}");
}
Console.WriteLine("-------------------------- Sum of All CPI ------------------------");
var stud26 = students.Sum(s => s.CPI);
Console.WriteLine($"Sum of All CPI: {stud26}");
Console.WriteLine("-------------------------- Min CPI in CE Branch ------------------------");
var stud27 = students.Where(s => s.Branch == "CE").Min(s => s.CPI);
Console.WriteLine($"Minimum CPI in CE Branch: {stud27}");
Console.WriteLine("-------------------------- Total Number of Students ------------------------");
var stud28 = students.Count();
Console.WriteLine($"Total Number of Students: {stud28}");
Console.WriteLine("-------------------------- Count of Students Having CPI < 6 ------------------------");
var stud29 = students.Count(s => s.CPI < 6);
Console.WriteLine($"Count of Students Having CPI < 6: {stud29}");
Console.WriteLine("-------------------------- Students Whose Age is Even ------------------------");
var stud30 = students.Where(s => s.Age % 2 == 0).ToList();
foreach (var student in stud30)
{
    Console.WriteLine($"Rno: {student.Rno}, Name: {student.Name}, Age: {student.Age}, Branch: {student.Branch}, CPI: {student.CPI}, sem: {student.sem}");
}
Console.WriteLine("-------------------------- Students Whose Name Contains 'a' ------------------------");
var stud31 = students.Where(s => s.Name.Contains("a")).ToList();
foreach (var student in stud31)
{
    Console.WriteLine($"Rno: {student.Rno}, Name: {student.Name}, Age: {student.Age}, Branch: {student.Branch}, CPI: {student.CPI}, sem: {student.sem}");
}
Console.WriteLine("-------------------------- Students Grouped by Age ------------------------");
var stud32 = students.GroupBy(s => s.Age).Select(g => new { Age = g.Key, Students = g.ToList() }).ToList();
foreach (var group in stud32)
{
    Console.WriteLine($"Age: {group.Age}");
    foreach (var student in group.Students)
    {
        Console.WriteLine($"  Rno: {student.Rno}, Name: {student.Name}, Branch: {student.Branch}, CPI: {student.CPI}, sem: {student.sem}");
    }
}
Console.WriteLine("-------------------------- Students Whose Name Has Exactly 5 Characters ------------------------");
var stud33 = students.Where(s => s.Name.Length == 5).ToList();
foreach (var student in stud33)
{
    Console.WriteLine($"Rno: {student.Rno}, Name: {student.Name}, Age: {student.Age}, Branch: {student.Branch}, CPI: {student.CPI}, sem: {student.sem}");
}
Console.WriteLine("-------------------------- Join Stude    nts with Dummy Department Table ------------------------");
Console.WriteLine("-------------------------- Join Students with CPI Rating Table ------------------------");
Console.WriteLine("-------------------------- Students in Semester 5 and CE Branch ------------------------");
Console.WriteLine("-------------------------- Students with Name in Uppercase ------------------------");
Console.WriteLine("-------------------------- Students with CPI Rounded to Nearest Integer ------------------------");
Console.WriteLine("-------------------------- Display First Student ------------------------");
Console.WriteLine("-------------------------- Display Last Student ------------------------");
Console.WriteLine("-------------------------- Display Student at Index 3 ------------------------");
Console.WriteLine("-------------------------- Reverse Student List ------------------------");
Console.WriteLine("-------------------------- Select Student Object to Anonymous Type ------------------------");
Console.WriteLine("-------------------------- Convert to Dictionary<Rno, Name> ------------------------");
Console.WriteLine("-------------------------- Remove Duplicates by Name ------------------------");
Console.WriteLine("-------------------------- Get Names of All Students Joined by Comma ------------------------");
Console.WriteLine("-------------------------- Get CPI Greater Than Average CPI ------------------------");
Console.WriteLine("-------------------------- Branch Wise Average CPI ------------------------");
Console.WriteLine("-------------------------- Semester Wise Maximum CPI ------------------------");
Console.WriteLine("-------------------------- Check if All Students Are Above 18 ------------------------");
Console.WriteLine("-------------------------- Get Oldest Student ------------------------");
