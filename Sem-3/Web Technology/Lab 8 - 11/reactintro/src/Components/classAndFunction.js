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
}