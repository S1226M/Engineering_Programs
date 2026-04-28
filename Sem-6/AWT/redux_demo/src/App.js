import { useSelector, useDispatch } from 'react-redux';
import './App.css';
import { addStudent, removeStudent } from './slices/studentSlice';
import { useState } from 'react';

function App() {
  const [inputs , setInputs] = useState({});
  const data = useSelector((state) => state.students);
  const dispatch = useDispatch();

  return (
    <>
      <input type="id" placeholder='id' onChange={(e) => setInputs({...inputs, name: e.target.value})} />
      <input type="text" placeholder='Name' onChange={(e) => setInputs({...inputs, name: e.target.value})} />
      <input type="number" placeholder='Age' onChange={(e) => setInputs({...inputs, age: e.target.value})} />
      
      <button onClick={() => dispatch(addStudent(inputs))}>
        Add Student
      </button>

      <div>
        {data.map((stu, index) => (
          <li key={index}>{stu.name} <button onClick={() => dispatch(removeStudent(stu.id))}>Delete</button></li>
        ))}
      </div>

    </>
  );
}

export default App;