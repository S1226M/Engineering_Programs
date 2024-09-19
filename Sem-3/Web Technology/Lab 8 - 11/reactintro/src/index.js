import React from 'react';
import ReactDOM from 'react-dom/client';

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

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<App />);







//     <>
//       <h1>My name is {props.name}</h1>
//     </>
//   )
// }

// function Pqr(){
//   return(
//     <h1>hello word</h1>
//   )
// }

// function Home(){
//   return(
//     alert("Guyziiz to jo jota j nathi")
//   )
// }

// function About(){
//   return(<h1>About page</h1>)
// }

// root.render(
//     <>
//       <button onClick={()=>{
//         alert("Guyziiz to jota j nathi")
//       }}>Home</button>

//       {/* <Pqr />
//       <ABC />
//       <Stu name='smit' /> */}
//     </>
