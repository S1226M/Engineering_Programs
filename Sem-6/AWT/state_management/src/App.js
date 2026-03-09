// import './App.css';
// import { useState } from 'react';

// function LikeBtnCount({ likes }) {
//   return (
//     <span>{likes}</span>
//   );
// }

// function LikeButton({ likes, setLikes }) {
//   return (
//     <>
//       <button onClick={() => setLikes(likes + 1)}>
//         {likes} Like
//       </button>
//     </>
//   );
// }

// function App() {
//   const [likes, setLikes] = useState(101);

//   return (
//     <>
//       <LikeBtnCount likes={likes} />
//       <LikeButton likes={likes} setLikes={setLikes} />
//     </>
//   );
// }

// export default App;

// ========================= i dont went to pass the props then i have to use the contect ==============
import './App.css';
import { useContext, useState, createContext } from 'react';

// create context
const LikeContext = createContext();

function LikeBtnCount() {
  const { likes } = useContext(LikeContext);

  return <span>{likes} from app</span>;
}

function LikeButton() {
  const { likes, setLikes } = useContext(LikeContext);

  return (
    <button onClick={() => setLikes(likes + 1)}>
      {likes} Like
    </button>
  );
}

function App() {
  const [likes, setLikes] = useState(101);

  return (
    <LikeContext.Provider value={{ likes, setLikes }}>
      <LikeBtnCount />
      <br />
      <LikeButton />
    </LikeContext.Provider>
  );
}

export default App;