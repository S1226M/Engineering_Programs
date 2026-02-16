// // // // // // // // // // // // // // // // //  useSate , useEffect , SetInterval // // // // // // // // // // // // // // // // //
// import './App.css';
// import { useState, useEffect } from 'react';

// function App() {
//   const [count, setCount] = useState(10);
//   const [faster, setFaster] = useState(false);

//   useEffect(() => {
//     setInterval(() => {
//        console.log("Hello world");
//      }, 1000);
//   },[faster]);

//   return (
//     <>
//       <button onClick={() => setCount(count + 1)}>
//         Increment
//       </button>
//       &nbsp;
//       <button onClick={() => setFaster(!faster)}>
//         Faster
//       </button>
//       <br />
//       React Hook Demo #{count}
//     </>
//   );
// }

// export default App;


// // // // // // // // // // // // // //  components => with Props
import { createContext, useContext } from 'react';
import './App.css';
// function AComp(props) {
//   const ans = props.ans;
//   return <>{ans}</>
// }

//=> // Destructure the Props {ans} and this call Properyt 
//            drilling (if we dont need to do this drilling the we have to use the useContext hook) 

// =======> this is app the value in the children component not pass in the non child component.
const AnsContext = createContext(); 

// function AComp({ans}) {
//   return <><BComp ans={ans} /> </>
// }
// function BComp({ans}) {
//   return <>{ans}</>
// }

function AComp() {
  return <><BComp/> </>
}
function BComp() {
  const ans = useContext(AnsContext);
  return <>B = {ans}</>
}

function App() {
  const ans = 10;
  return (
    <>
      <AnsContext.Provider value={ans}>  
        Answer = 
        <AComp/>
      </AnsContext.Provider>
    </>
  );
}

export default App;
