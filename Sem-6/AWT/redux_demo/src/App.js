import { useSelector } from 'react-redux';
import './App.css';

function App() {
  const [data] = useSelector((state) => state.students);
  console.log(data.name);
  return (
    <>
      <h1>Redux Demo</h1>
    </>
  );
}

export default App;
