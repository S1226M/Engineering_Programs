// // // // // // // // // // // // // // // // //  useSate , useEffect , SetInterval // // // // // // // // // // // // // // // // //
// import './App.css';
// import { useState, useEffect } from 'react';

// import { useMemo, useState } from "react";

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


// // // // // // // // // // // // // // //  components => with Props // // // // // // // // // // // // // // //
// import { createContext, useContext } from 'react';
// import './App.css';
// // function AComp(props) {
// //   const ans = props.ans;
// //   return <>{ans}</>
// // }

// //=> // Destructure the Props {ans} and this call Properyt 
// //            drilling (if we dont need to do this drilling the we have to use the useContext hook) 

// // =======> this is app the value in the children component not pass in the non child component.

// // function AComp({ans}) {
//   //   return <><BComp ans={ans} /> </>
//   // }
//   // function BComp({ans}) {
//     //   return <>{ans}</>
//     // }
    
// const AnsContext = createContext(); 

// function AComp() {
//   return <><BComp/> </>
// }
// function BComp() {
//   const ans = useContext(AnsContext);
//   return <>B = {ans}</>
// }

// function App() {
//   const ans = 10;
//   return (
//     <>
//       <AnsContext.Provider value={ans}>  
//         Answer = 
//         <AComp/>
//       </AnsContext.Provider>
//     </>
//   );
// }

// export default App;



// // =============================================================== useCallback Hook ===============================================================
// // when we can create the chat appilication then we can creat the socketID (connection id for the user) and 
// // we can create the function for send the message to the server and this function is pass in the child 
// // component and this function is change every time when state is change and this is unneccessary re-rendering 
// // of the component and this is not good for performance of the application. for this we have to use the useCallback hook to remember the state

// import { useCallback, useEffect, useState } from "react";

// function MyButton({abc}){
//   const [parentMethodChangeCount, setparentMethodChangeCount] = useState(0);
  
//   useEffect(() => {
//     setparentMethodChangeCount(parentMethodChangeCount + 1);
//   },[abc]);
//   // },[]); // abc function is chage possible

//   return(
//     <>
//       <button onClick={abc}>Increment - {parentMethodChangeCount}</button>
//     </>
//   )
// }

// // when state is change then code is re-render and abc function is change and MyButton 
// // -- component is re-render and useEffect is call and parentMethodChangeCount is change 

// // Solution => i dont need to create the abc function evey time so we have to use the useCallback hook 
// // and this is the best way to avoid the unneccessary re-rendering of the component.

// // we can add this in the useEffect we can do this but we can not use this function is in the useEffect
// // we can create the function in outside of the component and this is the best way to avoid the
// // ---  unneccessary re-rendering of the component but we can not pass in the props 

// function App() {
//   const [count, setCount] = useState(10); 

//   // function abc(){
//   //   setCount(count + 1);
//   // }

//   //using ES6 Arrow function
//   // const abc = () => {
//   //   setCount(count + 1);
//   // }

//   //use call back is memorise the function in the memory so that that can remain the all the state in the function so this is every time 
//   // + count in the last state 10 + 1 = 11 so count is update only one time. ==> this Call [[stale update]](no interest in any more)  
//   // const abc = useCallback(() => {
//   //   console.log("abc function is called");
//   //   setCount(count + 1);
//   // },[]);

//   const abc = useCallback(() => {
//     setCount((count) => {return count + 1});
//   },[])
//   // const abc = useCallback(()=>{
//   //   setCount(count => count + 1);
//   // })

//   return (
//     <>
//       Hellow World - {count}
//       <br/>
//       <MyButton abc={abc}/>
//     </>
//   );
// }

// export default App;


// ============================================================== use Memo Hook ===============================================================
// function App() {
//   const [count, setCount] = useState(0);
//   const [countTill, setCountTill] = useState(30000000);

//   // when state is chane then this for loop is run every time so this is slow dowm so we have to remember the varivle value so we can use the 
//   // useMemo hook
//   const sum = useMemo(() => {
//     let total = 0;
//     for(let i = 0; i < countTill; i++){
//       total += i;
//     }

//     return total;
//   },[countTill])

//   return(
//     <>
//       My Counter  - {count}
//       <br />
//       Count Till - {countTill}        
//       <br />
//       Total = {sum}
//       <br />
//       <button onClick={()=> {
//         setCount(count + 1);
//       }}>Increment</button>
//       <button onClick={() => {
//         setCountTill(countTill + 1);
//       }}>
//         Increment Count Till
//       </button>
//     </>
//   )
// }

// export default App;

import { useState, useRef } from "react";

// =================================================== Control Components ===============================================================
// when we have to change the state of the value from the input fild


function App() {
  const [name, setName] = useState("");          // live change
  const [finalName, setFinalName] = useState(""); // change after click
  const ref = useRef();

  return(
    <>
      <h2>Live Value : {name}</h2>
      <h2>After Click : {finalName}</h2>

      <input
        type="text"
        ref={ref}
        value={name}
        onChange={e => setName(e.target.value)}
      />

      <button onClick={() => setFinalName(ref.current.value)}>
        Click
      </button>
    </>
  )
}

export default App;