import React, { useState } from "react";
import JoinScreen from "./Components/JoinScreen";
import MeetingRoom from "./Components/MeetingRoom";
import axios from "axios";

function App() {
  const [token, setToken] = useState(null);
  const [roomId, setRoomId] = useState(null);
  const [userName, setUserName] = useState(null);
  const [isLoading, setIsLoading] = useState(false);
  const [error, setError] = useState(null);

  const handleJoin = async (roomId, name) => {
    setIsLoading(true);
    setError(null);
    
    try {
      const res = await axios.get(`https://localhost:7200/api/VideoSDK/token`);
      setToken(res.data.token);
      setRoomId(roomId);
      setUserName(name);
    } catch (error) {
      console.error("Error joining meeting:", error);
      setError("Failed to connect to the server. Please check if the backend is running.");
      throw error;
    } finally {
      setIsLoading(false);
    }
  };

  const handleLeave = () => {
    setToken(null);
    setRoomId(null);
    setUserName(null);
    setError(null);
  };

  if (error) {
    return (
      <div style={{
        display: 'flex',
        justifyContent: 'center',
        alignItems: 'center',
        height: '100vh',
        backgroundColor: '#f8f9fa'
      }}>
        <div style={{
          textAlign: 'center',
          padding: '40px',
          backgroundColor: 'white',
          borderRadius: '8px',
          boxShadow: '0 4px 6px rgba(0,0,0,0.1)',
          maxWidth: '400px'
        }}>
          <h2 style={{ color: '#dc3545', marginBottom: '20px' }}>Connection Error</h2>
          <p style={{ marginBottom: '20px', color: '#666' }}>{error}</p>
          <button
            onClick={() => {
              setError(null);
              setIsLoading(false);
            }}
            style={{
              padding: '10px 20px',
              backgroundColor: '#007bff',
              color: 'white',
              border: 'none',
              borderRadius: '5px',
              cursor: 'pointer',
              fontSize: '16px'
            }}
          >
            Try Again
          </button>
        </div>
      </div>
    );
  }

  return (
    <div>
      {!token ? (
        <JoinScreen onJoin={handleJoin} isLoading={isLoading} />
      ) : (
        <MeetingRoom 
          token={token} 
          roomId={roomId} 
          userName={userName}
          onLeave={handleLeave}
        />
      )}
    </div>
  );
}

export default App;
