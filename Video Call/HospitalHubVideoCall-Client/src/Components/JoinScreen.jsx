import React, { useState } from "react";

const JoinScreen = ({ onJoin }) => {
  const [roomId, setRoomId] = useState("");
  const [name, setName] = useState("");
  const [isJoining, setIsJoining] = useState(false);

  const handleJoin = async () => {
    if (!roomId.trim()) {
      alert("Please enter a room ID");
      return;
    }
    if (!name.trim()) {
      alert("Please enter your name");
      return;
    }
    
    setIsJoining(true);
    try {
      await onJoin(roomId.trim(), name.trim());
    } catch (error) {
      console.error("Failed to join:", error);
      alert("Failed to join the meeting. Please try again.");
    } finally {
      setIsJoining(false);
    }
  };

  const handleCreateRoom = async () => {
    if (!name.trim()) {
      alert("Please enter your name");
      return;
    }
    
    const newRoomId = Math.random().toString(36).substring(2, 15);
    setRoomId(newRoomId);
    handleJoin();
  };

  return (
    <div style={{ padding: '40px', maxWidth: '400px', margin: '0 auto', textAlign: 'center' }}>
      <h1 style={{ color: '#333', marginBottom: '30px' }}>Hospital Hub Video Call</h1>
      
      <div style={{ marginBottom: '20px' }}>
        <input
          type="text"
          placeholder="Enter your name"
          value={name}
          onChange={(e) => setName(e.target.value)}
          style={{
            width: '100%',
            padding: '12px',
            fontSize: '16px',
            border: '1px solid #ddd',
            borderRadius: '8px',
            marginBottom: '15px'
          }}
        />
        <input
          type="text"
          placeholder="Enter Room ID to join existing room"
          value={roomId}
          onChange={(e) => setRoomId(e.target.value)}
          style={{
            width: '100%',
            padding: '12px',
            fontSize: '16px',
            border: '1px solid #ddd',
            borderRadius: '8px'
          }}
        />
      </div>

      <div style={{ display: 'flex', gap: '10px', justifyContent: 'center' }}>
        <button 
          onClick={handleJoin}
          disabled={isJoining || !roomId.trim()}
          style={{
            padding: '12px 24px',
            fontSize: '16px',
            backgroundColor: '#007bff',
            color: 'white',
            border: 'none',
            borderRadius: '8px',
            cursor: 'pointer',
            opacity: isJoining || !roomId.trim() ? 0.6 : 1
          }}
        >
          {isJoining ? 'Joining...' : 'Join Room'}
        </button>
        
        <button 
          onClick={handleCreateRoom}
          disabled={isJoining}
          style={{
            padding: '12px 24px',
            fontSize: '16px',
            backgroundColor: '#28a745',
            color: 'white',
            border: 'none',
            borderRadius: '8px',
            cursor: 'pointer',
            opacity: isJoining ? 0.6 : 1
          }}
        >
          Create New Room
        </button>
      </div>
      
      <p style={{ marginTop: '20px', color: '#666', fontSize: '14px' }}>
        Share the Room ID with others to let them join your call
      </p>
    </div>
  );
};

export default JoinScreen;
