const students = [
  { id: 1, name: 'John', age: 22 },
  { id: 2, name: 'Jane', age: 20 },
  { id: 3, name: 'Alice', age: 23 },
];

function StudentList() {
  return (
    <div>
      <h2>Student List</h2>
      <ul>
        {students.map((student) => (
          <li key={student.id}>
            {student.name} - Age: {student.age}
          </li>
        ))}
      </ul>
    </div>
  );
}

function GetOldestStudentAge() {
  const ages = students.map(student => student.age);
  const oldestAge = Math.max.apply(null, ages);
  return <p>Oldest Student Age: {oldestAge}</p>;
}

function App() {
  return (
    <div>
      <StudentList />
      <GetOldestStudentAge />
    </div>
  );
}

default export map