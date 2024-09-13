import React from 'react';
import ReactDOM from 'react-dom/client';
import ABC from './Component'

const root = ReactDOM.createRoot(document.getElementById('root'));

function Stu(props){
  return(
    <>
      <h1>My name is {props.name}</h1>
    </>
  )
}

function Pqr(){
  return(
    <h1>hello word</h1>
  )
}

function Home(){
  return(
    alert("Guyziiz to jo jota j nathi")
  )
}

function About(){
  return(<h1>About page</h1>)
}

root.render(
    <>
      <button onClick={()=>{
        alert("Guyziiz to jota j nathi")
      }}>Home</button>

      {/* <Pqr />
      <ABC />
      <Stu name='smit' /> */}
    </>
);