import {
  MeetingProvider,
  useMeeting,
  useParticipant,
} from "@videosdk.live/react-sdk";
import React from "react";

const ParticipantView = ({ participantId }) => {
  const { displayName, webcamStream, micStream, isLocal, webcamOn, micOn } = useParticipant(participantId);
  const videoRef = React.useRef();
  const audioRef = React.useRef();

  React.useEffect(() => {
    if (webcamStream && videoRef.current) {
      const mediaStream = new MediaStream();
      mediaStream.addTrack(webcamStream.track);
      videoRef.current.srcObject = mediaStream;
    }
  }, [webcamStream]);

  React.useEffect(() => {
    if (micStream && audioRef.current) {
      const mediaStream = new MediaStream();
      mediaStream.addTrack(micStream.track);
      audioRef.current.srcObject = mediaStream;
      audioRef.current.play().catch(console.error);
    }
  }, [micStream]);

  return (
    <div style={{
      position: 'relative',
      width: '300px',
      height: '200px',
      margin: '10px',
      border: '2px solid #007bff',
      borderRadius: '8px',
      overflow: 'hidden',
      backgroundColor: '#000'
    }}>
      {webcamOn ? (
        <video 
          ref={videoRef} 
          autoPlay 
          playsInline 
          muted={isLocal}
          style={{
            width: '100%',
            height: '100%',
            objectFit: 'cover'
          }}
        />
      ) : (
        <div style={{
          width: '100%',
          height: '100%',
          display: 'flex',
          alignItems: 'center',
          justifyContent: 'center',
          backgroundColor: '#333',
          color: 'white',
          fontSize: '48px'
        }}>
          👤
        </div>
      )}
      
      {!isLocal && (
        <audio ref={audioRef} autoPlay playsInline />
      )}
      
      <div style={{
        position: 'absolute',
        bottom: '10px',
        left: '10px',
        right: '10px',
        display: 'flex',
        justifyContent: 'space-between',
        alignItems: 'center'
      }}>
        <span style={{
          color: 'white',
          backgroundColor: 'rgba(0,0,0,0.7)',
          padding: '4px 8px',
          borderRadius: '4px',
          fontSize: '14px'
        }}>
          {displayName || 'Unknown'} {isLocal ? "(You)" : ""}
        </span>
        
        <div style={{ display: 'flex', gap: '5px' }}>
          <span style={{ color: micOn ? '#28a745' : '#dc3545', fontSize: '16px' }}>
            {micOn ? '🎤' : '🎤'}
          </span>
          <span style={{ color: webcamOn ? '#28a745' : '#dc3545', fontSize: '16px' }}>
            {webcamOn ? '📹' : '📹'}
          </span>
        </div>
      </div>
    </div>
  );
};

const MeetingControls = ({ onLeave }) => {
  const { toggleMic, toggleWebcam, leave, localMicOn, localWebcamOn } = useMeeting();

  const handleLeave = () => {
    leave();
    onLeave();
  };

  return (
    <div style={{
      position: 'fixed',
      bottom: '20px',
      left: '50%',
      transform: 'translateX(-50%)',
      display: 'flex',
      gap: '15px',
      backgroundColor: 'rgba(0,0,0,0.8)',
      padding: '15px',
      borderRadius: '25px'
    }}>
      <button
        onClick={toggleMic}
        style={{
          width: '50px',
          height: '50px',
          borderRadius: '50%',
          border: 'none',
          backgroundColor: localMicOn ? '#28a745' : '#dc3545',
          color: 'white',
          fontSize: '20px',
          cursor: 'pointer',
          display: 'flex',
          alignItems: 'center',
          justifyContent: 'center'
        }}
      >
        {localMicOn ? '🎤' : '🎤'}
      </button>
      
      <button
        onClick={toggleWebcam}
        style={{
          width: '50px',
          height: '50px',
          borderRadius: '50%',
          border: 'none',
          backgroundColor: localWebcamOn ? '#28a745' : '#dc3545',
          color: 'white',
          fontSize: '20px',
          cursor: 'pointer',
          display: 'flex',
          alignItems: 'center',
          justifyContent: 'center'
        }}
      >
        {localWebcamOn ? '📹' : '📹'}
      </button>
      
      <button
        onClick={handleLeave}
        style={{
          width: '50px',
          height: '50px',
          borderRadius: '50%',
          border: 'none',
          backgroundColor: '#dc3545',
          color: 'white',
          fontSize: '20px',
          cursor: 'pointer',
          display: 'flex',
          alignItems: 'center',
          justifyContent: 'center'
        }}
      >
        📞
      </button>
    </div>
  );
};

const MeetingView = ({ roomId, onLeave }) => {
  const { join, participants, localParticipant } = useMeeting({
    onMeetingJoined: () => {
      console.log('Meeting Joined Successfully');
    },
    onMeetingLeft: () => {
      console.log('Meeting Left');
      onLeave();
    }
  });

  React.useEffect(() => {
    join();
  }, []);

  const participantsList = Array.from(participants.keys());

  return (
    <div style={{ height: '100vh', backgroundColor: '#f8f9fa', position: 'relative' }}>
      <div style={{
        padding: '20px',
        backgroundColor: '#007bff',
        color: 'white',
        textAlign: 'center'
      }}>
        <h2>Video Call - Room: {roomId}</h2>
        <p>Participants: {participantsList.length}</p>
      </div>
      
      <div style={{
        display: 'flex',
        flexWrap: 'wrap',
        justifyContent: 'center',
        alignItems: 'center',
        padding: '20px',
        minHeight: 'calc(100vh - 140px)'
      }}>
        {participantsList.length > 0 ? (
          participantsList.map((participantId) => (
            <ParticipantView key={participantId} participantId={participantId} />
          ))
        ) : (
          <div style={{
            textAlign: 'center',
            color: '#666',
            fontSize: '18px'
          }}>
            <p>Connecting to meeting...</p>
          </div>
        )}
      </div>
      
      <MeetingControls onLeave={onLeave} />
    </div>
  );
};

const MeetingRoom = ({ token, roomId, userName, onLeave }) => {
  return (
    <MeetingProvider
      config={{ 
        meetingId: roomId, 
        micEnabled: true, 
        webcamEnabled: true,
        name: userName,
        mode: 'CONFERENCE'
      }}
      token={token}
    >
      <MeetingView roomId={roomId} onLeave={onLeave} />
    </MeetingProvider>
  );
};

export default MeetingRoom;
